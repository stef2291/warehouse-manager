package org.example.Stubs;

import org.example.Database.Inventory;
import org.example.Database.SupplierInformation;
import org.example.ProductManagement.Product;
import org.example.People.*;

public class StubData {

    public static void populate(Inventory inventory, SupplierInformation supplierInformation) {
        Supplier Primark = new Supplier("Primark", "123-456-7890", "primark@example.com", "Primark Address");
        supplierInformation.addSupplier(Primark);

        Product t_shirt = new Product("T-shirt", 12.90, 15, 20);
        Primark.addProduct(t_shirt);
        inventory.addProduct(t_shirt);

        Product jeans = new Product("Jeans", 49.99, 57, 20);
        Primark.addProduct(jeans);
        inventory.addProduct(jeans);

        Product jacket = new Product("Jacket", 170.00, 50, 20);
        Primark.addProduct(jacket);
        inventory.addProduct(jacket);

        Product socks = new Product("Socks", 6.99, 80, 20);
        Primark.addProduct(socks);
        inventory.addProduct(socks);

        Product hat = new Product("Hat", 20.50, 17, 20);
        Primark.addProduct(hat);
        inventory.addProduct(hat);

        Supplier Screwfix = new Supplier("Screwfix", "123-456-7890", "screwfix@example.com", "Screwfix Address");
        supplierInformation.addSupplier(Screwfix);

        Product hammer = new Product("Hammer", 17.99, 33, 20);
        Screwfix.addProduct(hammer);
        inventory.addProduct(hammer);

        Product screwdriver = new Product("Screwdriver", 4.75, 15, 20);
        Screwfix.addProduct(screwdriver);
        inventory.addProduct(screwdriver);

        Product drill = new Product("Drill", 22.45, 42, 20);
        Screwfix.addProduct(drill);
        inventory.addProduct(drill);

        Product wrench = new Product("Wrench", 5.30, 65, 20);
        Screwfix.addProduct(wrench);
        inventory.addProduct(wrench);

        Product saw = new Product("Saw", 60.00, 86, 20);
        Screwfix.addProduct(saw);
        inventory.addProduct(saw);

        Supplier PCWorld = new Supplier("PC World", "123-456-7890", "pcworld@example.com", "PC World Address");
        supplierInformation.addSupplier(PCWorld);

        Product laptop = new Product("Laptop", 800, 42, 20);
        PCWorld.addProduct(laptop);
        inventory.addProduct(laptop);

        Product monitor = new Product("Monitor", 100, 67, 20);
        PCWorld.addProduct(monitor);
        inventory.addProduct(monitor);

        Product mouse = new Product("Mouse", 4.55, 54, 20);
        PCWorld.addProduct(mouse);
        inventory.addProduct(mouse);

        Product keyboard = new Product("Keyboard", 18.45, 57, 20);
        PCWorld.addProduct(keyboard);
        inventory.addProduct(keyboard);

        Product printer = new Product("Printer", 150.00, 44, 20);
        PCWorld.addProduct(printer);
        inventory.addProduct(printer);
    }
}
