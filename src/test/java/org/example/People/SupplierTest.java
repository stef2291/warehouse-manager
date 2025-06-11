package org.example.People;
import org.example.ProductManagement.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SupplierTest {
    Product product;
    Supplier supplier;

    @BeforeEach
    void setUp() {
        supplier = new Supplier("Primark", "0123", "email", "addr");
        product = new Product("Hammer", 10.0, 5, 10);
    }
    @Test
    void testSupplierName() {
        Supplier newSupplier = new Supplier("Primark", "020111222", "primark@gmail.com", "22 Primark Avenue");
        assertEquals("Primark", newSupplier.getName());
        assertEquals("Email : primark@gmail.com\n" +
                "Address : 22 Primark Avenue\n" +
                "Phone Number : 020111222", newSupplier.getContactInfo().toString());
    }

    void testSupplierCreation() {
        Supplier supplier = new Supplier("Primark", "0123456789", "primark@example.com", "123 High St");
        assertEquals("Primark", supplier.getName());
        assertTrue(supplier.getId().length() > 0);
        assertTrue(supplier.getContactInfo().getEmail().contains("primark@example.com"));
    }

    @Test
    void testAddProduct() {
        supplier.addProduct(product);
        assertEquals(5, supplier.getProductsList(0).getQuantity());
        assertTrue(supplier.getProductsList(0).getProductId().contains("Hammer"));
    }

    @Test
    void testRemoveProduct() {
        supplier.addProduct(product);
        supplier.removeProduct(product);

        assertThrows(IndexOutOfBoundsException.class, () -> supplier.getProductsList(0));
    }

    @Test
    void testGetContactInfoByType() {
        assertEquals("email", supplier.getIndividualContactInfo(Supplier.ContactDetails.EMAIL));
        assertEquals("0123", supplier.getIndividualContactInfo(Supplier.ContactDetails.PHONE));
        assertEquals("addr", supplier.getIndividualContactInfo(Supplier.ContactDetails.ADDRESS));
    }
}
