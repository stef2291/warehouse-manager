package org.example.Database;

import org.example.Supplier.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private Inventory inventory;
    private Product product;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        product = new Product("Hammer", 12.99, 7, 5);
        product.setProductId("prod-001");
        inventory.addProduct(product);
    }

    @Test
    void addAndGetProduct() {
        Product getHammerUsingID = inventory.getProduct("prod-001");
        assertEquals("Hammer", getHammerUsingID.getProductName());
    }

    @Test
    void updateQuantity() {
        assertEquals(7, product.getQuantity());
        inventory.updateQuantity("prod-001", 25);
        inventory.getProduct("prod-001");
        assertEquals(25, product.getQuantity());
    }

    @Test
    void getAllProducts() {
        Map<String, Product> allProducts = inventory.getAllProducts();
        assertEquals(1, allProducts.size());
        assertTrue(allProducts.containsKey("prod-001"));
    }

    @Test
    void updateNonExistantProduct() {
        inventory.updateQuantity("product-does-not-exist", 20);
        assertNull(inventory.getProduct("product-does-not-exist"));
    }

    @Test
    void lowStockAlert() {
        Product productInLowStock = new Product("Shoes", 40, 2, 5);
        Product productInHighStock = new Product("Plates", 1.99, 30, 8);
        inventory.addProduct(productInHighStock);

        List<Product> lowStockList1 = inventory.lowStockAlert();
        assertTrue(lowStockList1.isEmpty());

        inventory.addProduct(productInLowStock);
        List<Product> lowStockList2 = inventory.lowStockAlert();
        assertEquals(1, lowStockList2.size());
        assertEquals("Shoes", lowStockList2.get(0).getProductName());    }
}
