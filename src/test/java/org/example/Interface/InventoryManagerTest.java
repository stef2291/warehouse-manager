package org.example.Interface;

import org.example.Database.Inventory;
import org.example.ProductManagement.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagerTest {

    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testPromptForDouble_ValidInput() {
        String input = "19.99\n";
        Scanner scanner = new Scanner(input);
        InventoryManager manager = new InventoryManager(inventory, scanner);

        double result = manager.promptForDouble();
        assertEquals(19.99, result);
    }

    @Test
    public void testPromptForInteger_ValidInput() {
        String input = "42\n";
        Scanner scanner = new Scanner(input);
        InventoryManager manager = new InventoryManager(inventory, scanner);

        int result = manager.promptForInteger();
        assertEquals(42, result);
    }

    @Test
    public void testAddProductSuccessfully() {
        String input = String.join("\n",
                "Widget",   // product name
                "12.5",     // price
                "10",       // quantity
                "5"         // threshold
        ) + "\n";
        Scanner scanner = new Scanner(input);
        InventoryManager manager = new InventoryManager(inventory, scanner);

        manager.addProduct();

        Product added = inventory.getProduct("Widget");
        assertNotNull(added);
        assertEquals(12.5, added.getPrice());
        assertEquals(10, added.getQuantity());
        assertEquals(5, added.getThreshold());
    }

    @Test
    public void testAddProduct_DuplicateNameBlocked() {
        Product p = new Product("Gadget", 10.0, 5, 2);
        inventory.addProduct(p);

        String input = "Gadget\n";  // name already exists
        Scanner scanner = new Scanner(input);
        InventoryManager manager = new InventoryManager(inventory, scanner);

        manager.addProduct();  // should do nothing

        assertEquals(1, inventory.getAllProducts().size());
    }
}
