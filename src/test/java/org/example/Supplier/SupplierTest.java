package org.example.Supplier;
import org.example.Supplier.Product;
import org.example.Supplier.Supplier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SupplierTest {
    @Test
    void testSupplierName() {
        Supplier newSupplier = new Supplier("Primark", "020111222", "primark@gmail.com", "22 Primark Avenue");
        assertEquals("Primark", newSupplier.getName());
        assertEquals("Email : primark@gmail.com\n" +
                "Address : 22 Primark Avenue\n" +
                "Phone Number : 020111222", newSupplier.getContactInfo());
    }

    void testSupplierCreation() {
        Supplier supplier = new Supplier("Primark", "0123456789", "primark@example.com", "123 High St");
        assertEquals("Primark", supplier.getName());
        assertTrue(supplier.getSupplierID().length() > 0);
        assertTrue(supplier.getContactInfo().contains("primark@example.com"));
    }

    @Test
    void testAddProduct() {
        Supplier supplier = new Supplier("Primark", "0123", "email", "addr");
        Product product = new Product("Hammer", 10.0, 5);
        supplier.addProduct(product);

        assertEquals(5, supplier.getProductsList(0).getQuantity());
        assertTrue(supplier.getProductsList(0).getProductId().contains("Hammer"));
    }

    @Test
    void testRemoveProduct() {
        Supplier supplier = new Supplier("Primark", "0123", "email", "addr");
        Product product = new Product("Hammer", 10.0, 5);
        supplier.addProduct(product);
        supplier.removeProduct(product);

        assertThrows(IndexOutOfBoundsException.class, () -> supplier.getProductsList(0));
    }

    @Test
    void testGetContactInfoByType() {
        Supplier supplier = new Supplier("Primark", "0123", "email", "addr");
        assertEquals("email", supplier.getContactInfo(Supplier.ContactDetails.EMAIL));
        assertEquals("0123", supplier.getContactInfo(Supplier.ContactDetails.PHONE));
        assertEquals("addr", supplier.getContactInfo(Supplier.ContactDetails.ADDRESS));
    }
}
