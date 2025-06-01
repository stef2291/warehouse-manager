package org.example.Inventory;

import org.example.Supplier.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private Inventory inventory;
    private Product product;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        product = new Product("Hammer", 12.99, 10);
        product.setProductId("prod-001");
        inventory.addProduct(product);
    }

    @Test
    void addAndGetProduct() {
        Product retrieved = inventory.getProduct("prod-001");
        assertNotNull(retrieved);
        assertEquals("Hammer", retrieved.getProductName());
    }

    @Test
    void updateQuantity() {
        inventory.updateQuantity("prod-001", 25);
        Product updated = inventory.getProduct("prod-001");
        assertEquals(25, updated.getQuantity());
    }

    @Test
    void getAllProducts() {
        Map<String, Product> all = inventory.getAllProducts();
        assertEquals(1, all.size());
        assertTrue(all.containsKey("prod-001"));
    }

    @Test
    void updateNonExistantProduct() {
        inventory.updateQuantity("product-does-not-exist", 20);
        // No exception should occur; nothing is updated
        assertNull(inventory.getProduct("product-does-not-exist"));
    }
}
