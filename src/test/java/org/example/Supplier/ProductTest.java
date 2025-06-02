package org.example.Supplier;

import org.example.Supplier.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testProductFields() {
        Product product = new Product("Drill", 50.0, 10, 11);
        product.setProductId("123");

        assertEquals("123", product.getProductId());
        assertEquals("Drill", product.getProductName());
        assertEquals(50.0, product.getPrice());
        assertEquals(10, product.getQuantity());
    }

}
