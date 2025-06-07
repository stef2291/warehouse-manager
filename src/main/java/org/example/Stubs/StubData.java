package org.example.Stubs;

import org.example.Database.Inventory;
import org.example.Supplier.*;

public class StubData {

    public static void populate(Inventory inventory) {
        Supplier Primark = new Supplier("Primark", "123-456-7890", "primark@example.com", "Primark Address");

        Product t_shirt = new Product("T-shirt", 447.09, 15, 19);
        Primark.addProduct(t_shirt);
        inventory.addProduct(t_shirt);

        Product jeans = new Product("Jeans", 243.11, 57, 6);
        Primark.addProduct(jeans);
        inventory.addProduct(jeans);

        Product jacket = new Product("Jacket", 173.28, 99, 9);
        Primark.addProduct(jacket);
        inventory.addProduct(jacket);

        Product socks = new Product("Socks", 116.89, 80, 13);
        Primark.addProduct(socks);
        inventory.addProduct(socks);

        Product hat = new Product("Hat", 373.37, 77, 7);
        Primark.addProduct(hat);
        inventory.addProduct(hat);

        Supplier Screwfix = new Supplier("Screwfix", "123-456-7890", "screwfix@example.com", "Screwfix Address");

        Product hammer = new Product("Hammer", 117.98, 33, 18);
        Screwfix.addProduct(hammer);
        inventory.addProduct(hammer);

        Product screwdriver = new Product("Screwdriver", 473.77, 73, 14);
        Screwfix.addProduct(screwdriver);
        inventory.addProduct(screwdriver);

        Product drill = new Product("Drill", 222.18, 92, 9);
        Screwfix.addProduct(drill);
        inventory.addProduct(drill);

        Product wrench = new Product("Wrench", 105.42, 65, 20);
        Screwfix.addProduct(wrench);
        inventory.addProduct(wrench);

        Product saw = new Product("Saw", 77.91, 86, 16);
        Screwfix.addProduct(saw);
        inventory.addProduct(saw);

        Supplier PCWorld = new Supplier("PC World", "123-456-7890", "pcworld@example.com", "PC World Address");

        Product laptop = new Product("Laptop", 463.49, 42, 10);
        PCWorld.addProduct(laptop);
        inventory.addProduct(laptop);

        Product monitor = new Product("Monitor", 88.46, 67, 20);
        PCWorld.addProduct(monitor);
        inventory.addProduct(monitor);

        Product mouse = new Product("Mouse", 334.55, 54, 20);
        PCWorld.addProduct(mouse);
        inventory.addProduct(mouse);

        Product keyboard = new Product("Keyboard", 18.45, 57, 19);
        PCWorld.addProduct(keyboard);
        inventory.addProduct(keyboard);

        Product printer = new Product("Printer", 252.39, 44, 17);
        PCWorld.addProduct(printer);
        inventory.addProduct(printer);
    }

}
