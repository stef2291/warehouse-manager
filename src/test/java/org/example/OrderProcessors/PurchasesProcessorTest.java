package org.example.OrderProcessors;

import org.example.Database.Inventory;
import org.example.Orders.SupplierOrder;
import org.example.ProductManagement.Product;
import org.example.ProductManagement.SupplierOrderProduct;
import org.example.People.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PurchasesProcessorTest {

    private Inventory inventory;
    private Supplier supplier;
    private Product hammer, wrench;
    private SupplierOrder order;
    private PurchasesProcessor processor;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        supplier = new Supplier("Tools Inc", "123456", "tools@example.com", "123 Street");
        hammer = new Product("Hammer", 10.0, 0, 5);
        wrench = new Product("Wrench", 5.0, 0, 5);
        supplier.addProduct(hammer);
        supplier.addProduct(wrench);


        order = new SupplierOrder(supplier);
        order.addProducts(new SupplierOrderProduct(hammer, 10));
        order.addProducts(new SupplierOrderProduct(wrench, 20));

        processor = new PurchasesProcessor(inventory);
    }

    @Test
    void manageOrders() {
        processor.processOrder(order);

        assertEquals(2, inventory.getAllProducts().size());
        assertEquals(10, inventory.getProduct("Hammer").getQuantity());
        assertEquals(20, inventory.getProduct("Wrench").getQuantity());
        assertEquals(10 * 10.0 + 20 * 5.0, processor.getTotalPurchaseCost(), 0.01);
        assertEquals(SupplierOrder.Status.RECEIVED, order.getStatus());
    }

    @Test
    void handleNullOrder() {
        assertThrows(IllegalArgumentException.class, () -> processor.processOrder(null));
    }

    @Test
    void handleEmptyOrder() {
        SupplierOrder emptyOrder = new SupplierOrder(supplier);
        assertThrows(IllegalArgumentException.class, () -> processor.processOrder(emptyOrder));
    }

    @Test
    void returnOrderList() {
        processor.processOrder(order);
        List<SupplierOrder> processed = processor.getProcessedOrders();

        assertEquals(1, processed.size());
        assertEquals(order.getOrderId(), processed.get(0).getOrderId());
    }

}
