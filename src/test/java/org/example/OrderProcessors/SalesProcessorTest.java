package org.example.OrderProcessors;
import org.example.Customer.Customer;
import org.example.Customer.CustomerOrder;
import org.example.Customer.CustomerOrderProduct;
import org.example.Database.Inventory;
import org.example.Supplier.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalesProcessorTest {
    private Inventory inventory;
    private SalesProcessor salesProcessor;
    private Product hammer;
    private Product wrench;
    private Customer customer;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        salesProcessor = new SalesProcessor(inventory);

        hammer = new Product("Hammer", 10.0, 20, 5);
        hammer.setProductId("hammer-001");
        inventory.addProduct(hammer);
        wrench = new Product("Wrench", 5, 45, 10);
        wrench.setProductId("wrench-001");
        inventory.addProduct(wrench);
        customer = new Customer("John Doe", "john@example.com", "1234567890", "123 Main St");
    }

    @Test
    void reduceInventoryIncreaseRevenue() {
        CustomerOrder order = new CustomerOrder(customer);
        order.addProduct(new CustomerOrderProduct(hammer, 5));

        salesProcessor.processOrder(order);

        assertEquals(15, inventory.getProduct("hammer-001").getQuantity());
        assertEquals(50.0, salesProcessor.getTotalSalesRevenue(), 0.001);
        assertEquals(CustomerOrder.Status.SHIPPED, order.getStatus());
        assertEquals(1, salesProcessor.getProcessedOrders().size());
    }

    @Test
    void insufficientStockPartial() {
        CustomerOrder order = new CustomerOrder(customer);
        order.addProduct(new CustomerOrderProduct(hammer, 100));
        order.addProduct(new CustomerOrderProduct(wrench, 30));

        salesProcessor.processOrder(order);

        assertEquals(20, inventory.getProduct("hammer-001").getQuantity());
        assertEquals(15, inventory.getProduct("wrench-001").getQuantity());
        assertEquals(150, salesProcessor.getTotalSalesRevenue(), 0.001);
        assertEquals(CustomerOrder.Status.PARTIAL, order.getStatus());
        assertEquals(1, salesProcessor.getProcessedOrders().size());
    }

    @Test
    void insufficientStockCancelled() {
        CustomerOrder order = new CustomerOrder(customer);
        order.addProduct(new CustomerOrderProduct(hammer, 100));
        order.addProduct(new CustomerOrderProduct(wrench, 50));

        salesProcessor.processOrder(order);

        assertEquals(20, inventory.getProduct("hammer-001").getQuantity());
        assertEquals(45, inventory.getProduct("wrench-001").getQuantity());
        assertEquals(0, salesProcessor.getTotalSalesRevenue(), 0.001);
        assertEquals(CustomerOrder.Status.CANCELLED, order.getStatus());
        assertEquals(0, salesProcessor.getProcessedOrders().size());
    }

    @Test
    void unknownProduct() {
        Product unknown = new Product("Banana", 15.0, 1, 1);
        unknown.setProductId("unknown-001");
        CustomerOrder order = new CustomerOrder(customer);
        order.addProduct(new CustomerOrderProduct(unknown, 1));
        salesProcessor.processOrder(order);

        assertEquals(0.0, salesProcessor.getTotalSalesRevenue(), 0.001);
        assertEquals(CustomerOrder.Status.CANCELLED, order.getStatus());
    }

    @Test
    void nullOrderException() {
        assertThrows(IllegalArgumentException.class, () -> {
            salesProcessor.processOrder(null);
        });
    }

    @Test
    void emptyOrderException() {
        CustomerOrder order = new CustomerOrder(customer);
        assertThrows(IllegalArgumentException.class, () -> {
            salesProcessor.processOrder(order);
        });
    }
}
