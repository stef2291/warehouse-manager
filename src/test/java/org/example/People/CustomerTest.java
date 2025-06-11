package org.example.People;

import org.example.Orders.CustomerOrder;
import org.example.ProductManagement.CustomerOrderProduct;
import org.example.ProductManagement.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private Customer customer;
    private Product product;
    private CustomerOrderProduct orderProduct;
    private CustomerOrder order;
    private ContactInfo contact;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", "john@example.com", "1234567890", "22 Acacia Ave");
        product = new Product("Tshirt", 9.99, 3, 2);
        orderProduct = new CustomerOrderProduct(product, 2);
        order = new CustomerOrder(customer);
    }

    @Test
    void customerCreation() {

        assertNotNull(customer.getId());
        assertEquals("John Doe", customer.getName());
        contact = customer.getContactInfo();
        assertEquals("john@example.com", contact.getEmail());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("22 Acacia Ave", contact.getAddress());
    }

}
