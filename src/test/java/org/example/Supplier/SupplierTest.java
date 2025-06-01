package org.example.Supplier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SupplierTest {
    @Test
    void testSupplierName() {
        Supplier newSupplier = new Supplier("Primark", "020111222", "primark@gmail.com", "22 Primark Avenue");
        assertEquals("Primark", newSupplier.getName());
    }
}
