package org.example.ProductManagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SupplierOrderProductTest {
    @Test
    void testOrderProduct() {
        Product p1 = new Product("Saw", 25.0, 3, 11);
        SupplierOrderProduct sop = new SupplierOrderProduct(p1, 7);

        assertEquals("Saw", sop.getProduct().getProductName());
        assertEquals(7, sop.getQuantity());

        Product p2 = new Product("Hammer", 1000.0, 20, 10);


        sop.setProduct(p2);
        sop.setQuantity(5);
        assertEquals("Hammer", sop.getProduct().getProductName());
        assertEquals(5, sop.getQuantity());
    }
}
