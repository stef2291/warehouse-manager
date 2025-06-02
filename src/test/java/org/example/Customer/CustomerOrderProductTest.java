package org.example.Customer;

import org.example.Supplier.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerOrderProductTest {
    @Test
    void create_customerOrderProduct() {
        Product product = new Product("Mouse", 15.0, 50, 100);
        CustomerOrderProduct item = new CustomerOrderProduct(product, 3);

        assertEquals(product, item.getProduct());
        assertEquals(3, item.getQuantity());
    }

    @Test
    void setters() {
        Product p1 = new Product("Monitor", 200.0, 5, 20);
        Product p2 = new Product("Laptop", 1000.0, 20, 10);
        CustomerOrderProduct item = new CustomerOrderProduct(p1, 1);

        item.setProduct(p2);
        item.setQuantity(4);

        assertEquals(p2, item.getProduct());
        assertEquals(4, item.getQuantity());
    }
}
