package org.example.Supplier;

import org.example.Supplier.Product;
import org.example.Supplier.Supplier;
import org.example.Supplier.SupplierOrder;
import org.example.Supplier.SupplierOrderProduct;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SupplierOrderTest {
    @Test
    void testOrderCreationAndProductManagement() {
        Supplier supplier = new Supplier("Homebase", "0987", "home@base.com", "22 London Rd");
        SupplierOrder order = new SupplierOrder(supplier);

        assertEquals(SupplierOrder.Status.PENDING, order.getStatus());
        assertEquals(supplier, order.getSupplier());

        Product product = new Product("Screw", 0.10, 100);
        SupplierOrderProduct sop = new SupplierOrderProduct(product, 20);

        order.addProducts(sop);
        assertEquals(1, order.getProducts().size());

        order.removeProduct(sop);
        assertEquals(0, order.getProducts().size());
    }

    @Test
    void testStatusUpdate() {
        Supplier supplier = new Supplier("B&Q", "1111", "b@q.com", "Some St");
        SupplierOrder order = new SupplierOrder(supplier);
        order.setStatus(SupplierOrder.Status.APPROVED);

        assertEquals(SupplierOrder.Status.APPROVED, order.getStatus());
    }

    @Test
    void testToStringOutput() {
        Supplier supplier = new Supplier("Wickes", "222", "w@ks.com", "St Lane");
        SupplierOrder order = new SupplierOrder(supplier);
        Product product = new Product("Bolt", 0.20, 50);
        SupplierOrderProduct sop = new SupplierOrderProduct(product, 5);
        order.addProducts(sop);

        String output = order.toString();
        assertTrue(output.contains("Bolt"));
        assertTrue(output.contains("Qty: 5"));
    }
}
