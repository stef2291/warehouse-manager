package org.example.Supplier;

import org.example.Supplier.Product;
import org.example.Supplier.SupplierOrderProduct;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SupplierOrderProductTest {
    @Test
    void testOrderProduct() {
        Product p = new Product("Saw", 25.0, 3, 11);
        SupplierOrderProduct sop = new SupplierOrderProduct(p, 7);

        assertEquals("Saw", sop.getProduct());
        assertEquals(7, sop.getQuantity());

        sop.setProduct("Hammer");
        sop.setQuantity(5);
        assertEquals("Hammer", sop.getProduct());
        assertEquals(5, sop.getQuantity());
    }
}
