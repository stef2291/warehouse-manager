package org.example.Interface;

import org.example.Database.Inventory;
import org.example.Database.SupplierInformation;
import org.example.OrderProcessors.PurchasesProcessor;
import org.example.ProductManagement.Product;
import org.example.People.Supplier;
import org.example.Orders.SupplierOrder;
import org.example.ProductManagement.SupplierOrderProduct;

import java.util.Scanner;

public class PurchasesManager extends Manager {
    private final SupplierInformation supplierInfo;
    private final Inventory inventory;
    private final PurchasesProcessor purchasesProcessor;

    public PurchasesManager(SupplierInformation supplierInfo, Inventory inventory, Scanner scanner) {
        super(scanner);
        this.inventory = inventory;
        this.supplierInfo = supplierInfo;
        this.purchasesProcessor = new PurchasesProcessor(inventory);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("\n--- Purchase Management ---");
            System.out.println("1. Create Purchase Order");
            System.out.println("2. View Processed Orders");
            System.out.println("3. View Total Purchase Cost");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": createPurchaseOrder(); break;
                case "2": viewProcessedOrders(); break;
                case "3": viewTotalCost(); break;
                case "4": return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    void createPurchaseOrder() {
        var suppliers = supplierInfo.getAllSuppliers();
        if (suppliers.isEmpty()) {
            System.out.println("No suppliers available.");
            return;
        }

        System.out.println("\nAvailable Suppliers:");
        for (int i = 0; i < suppliers.size(); i++) {
            System.out.println((i + 1) + ". " + suppliers.get(i).getName());
        }

        System.out.print("Select a supplier by number: ");
        int index = promptForInteger() - 1;
        if (index < 0 || index >= suppliers.size()) {
            System.out.println("Invalid supplier selection.");
            return;
        }

        Supplier supplier = suppliers.get(index);
        SupplierOrder order = new SupplierOrder(supplier);

        while (true) {
            System.out.println("\nAvailable Products:");
            for (int i = 0; ; i++) {
                try {
                    Product p = supplier.getProductsList(i);
                    System.out.println((i + 1) + ". " + p.getProductName() + " (£" + p.getPrice() + ")");
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }

            System.out.print("Enter product number to add (or 0 to finish): ");
            int productChoice = promptForInteger();
            if (productChoice == 0) break;

            try {
                Product selectedProduct = supplier.getProductsList(productChoice - 1);
                System.out.print("Enter quantity: ");
                int qty = promptForInteger();

                SupplierOrderProduct orderProduct = new SupplierOrderProduct(selectedProduct, qty);
                order.addProducts(orderProduct);
                System.out.println("Product added.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid product selection.");
            }
        }

        if (order.getProducts().isEmpty()) {
            System.out.println("No products selected. Order cancelled.");
            return;
        }

        purchasesProcessor.processOrder(order);
        System.out.println("Order processed successfully!");
    }

    private void viewProcessedOrders() {
        var orders = purchasesProcessor.getProcessedOrders();
        if (orders.isEmpty()) {
            System.out.println("No processed orders yet.");
            return;
        }

        for (SupplierOrder o : orders) {
            System.out.println(o);
        }
    }

    private void viewTotalCost() {
        System.out.println("Total Purchase Cost: £" + purchasesProcessor.getTotalPurchaseCost());
    }
}
