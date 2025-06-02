package org.example.Customer;

import org.example.Supplier.ContactInfo;
import org.example.Supplier.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerOrderTest {
    private Customer customer;
    private Product product;
    private CustomerOrderProduct orderProduct;
    private CustomerOrder order;
    private ContactInfo contact;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", "john@example.com", "1234567890", "22 Acacia Ave");
        product = new Product("Tshirt", 9.99, 3, 20);
        orderProduct = new CustomerOrderProduct(product, 2);
        order = new CustomerOrder(customer);
    }

    void create_customer_order() {

    }

    @Test
    void customerOrderCreation() {

        assertNotNull(order.getOrderId());
        assertEquals(CustomerOrder.Status.PENDING, order.getStatus());
        assertEquals(customer, order.getCustomer());
        assertEquals(0, order.getProducts().size());
    }

    @Test
    void addProductInList() {

        order.addProduct(orderProduct);

        List<CustomerOrderProduct> products = order.getProducts();
        assertEquals(1, products.size());
        assertEquals("Tshirt", products.get(0).getProduct().getProductName());
    }

    @Test
    void changeOrderStatus() {
        order.setStatus(CustomerOrder.Status.APPROVED);
        assertEquals(CustomerOrder.Status.APPROVED, order.getStatus());
    }
}
