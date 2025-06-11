package org.example.Interface;

import org.example.Database.Inventory;
import org.example.ProductManagement.Product;

import java.util.Map;
import java.util.Scanner;

public class InventoryManager extends Manager {
    private final Inventory inventory;

    public InventoryManager(Inventory inventory, Scanner scanner) {
        super(scanner);
        this.inventory = inventory;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Modify Product");
            System.out.println("4. View Low Stock Products");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": viewProducts(); break;
                case "2": addProduct(); break;
                case "3": modifyProduct(); break;
                case "4": viewLowStock(); break;
                case "5": return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void viewProducts() {
        Map<String, Product> products = inventory.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }

        for (Product p : products.values()) {
            System.out.println(p.getProductName());
            System.out.println("£ " + p.getPrice() + " per item");
            System.out.println(p.getQuantity() + " " + p.getProductName() + "s left in stock!");
        }
    }

    void addProduct() {

        double price;
        int quantity;
        int threshold;

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        if(inventory.getAllProducts().containsKey(name)) {
            System.out.println("Product " + name + " already exists, select option number 3 (Modify Product) if you would like to modify the existing entry");
            return;
        }

        System.out.print("Enter price: ");
        price = promptForDouble();

        System.out.print("Enter quantity: ");
        quantity = promptForInteger();

        System.out.print("Enter stock threshold: ");
        threshold = promptForInteger();

        Product product = new Product(name, price, quantity, threshold);
        inventory.addProduct(product);

        System.out.println("Product added: " + product.getProductName());
    }

    private void modifyProduct() {
        System.out.print("Enter product Name: ");
        String productId = scanner.nextLine();

        Product product = inventory.getProduct(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new name (current: " + product.getProductName() + "): ");
        product.setProductName(scanner.nextLine());

        System.out.print("Enter new price (current: " + product.getPrice() + "): ");
        product.setPrice(promptForDouble());

        System.out.print("Enter new quantity (current: " + product.getQuantity() + "): ");
        product.setQuantity(promptForInteger());

        System.out.print("Enter new threshold (current: " + product.getThreshold() + "): ");
        product.setThreshold(promptForInteger());

        System.out.println("Product updated.");
    }

    private void viewLowStock() {
        var lowStock = inventory.lowStockAlert();
        if (lowStock.isEmpty()) {
            System.out.println("No low stock alerts.");
        } else {
            System.out.println("--- Low Stock Products ---");
            for (Product p : lowStock) {
                System.out.println(p.getProductName());
                System.out.println("£ " + p.getPrice() + " per item");
                System.out.println("Only " + p.getQuantity() + " " + p.getProductName() + "s left in stock!" + " The stock should always be above " + p.getThreshold() +  ".");
            }
        }
    }
}