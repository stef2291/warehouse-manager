package org.example.Database;

import org.example.People.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SupplierInformationTest {
    private SupplierInformation supplierInformation;
    private Supplier supplier1;
    private Supplier supplier2;

    @BeforeEach
    public void setUp() {
        supplierInformation = new SupplierInformation();
        supplier1 = new Supplier("Supplier One", "111-111", "one@email.com", "Address 1");
        supplier2 = new Supplier("Supplier Two", "222-222", "two@email.com", "Address 2");
    }
    @Test
    public void testAddSupplier() {
        supplierInformation.addSupplier(supplier1);
        List<Supplier> suppliers = supplierInformation.getAllSuppliers();
        assertEquals(1, suppliers.size());
        assertEquals("Supplier One", suppliers.get(0).getName());
    }

    @Test
    public void testGetSupplier() {
        supplierInformation.addSupplier(supplier1);
        supplierInformation.addSupplier(supplier2);
        Supplier retrieved = supplierInformation.getSupplier(1);
        assertEquals("Supplier Two", retrieved.getName());
    }

    @Test
    public void testRemoveSupplier() {
        supplierInformation.addSupplier(supplier1);
        supplierInformation.addSupplier(supplier2);
        supplierInformation.removeSupplier(0);
        List<Supplier> suppliers = supplierInformation.getAllSuppliers();
        assertEquals(1, suppliers.size());
        assertEquals("Supplier Two", suppliers.get(0).getName());
    }

    @Test
    public void testGetAllSuppliersReturnsDefensiveCopy() {
        supplierInformation.addSupplier(supplier1);
        List<Supplier> list = supplierInformation.getAllSuppliers();
        list.clear(); // Should not affect the internal list
        assertEquals(1, supplierInformation.getAllSuppliers().size());
    }
}
