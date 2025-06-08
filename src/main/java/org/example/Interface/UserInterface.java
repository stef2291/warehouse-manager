package org.example.Interface;

import org.example.Database.Inventory;
import org.example.Database.SupplierInformation;
import org.example.OrderProcessors.PurchasesProcessor;
import org.example.OrderProcessors.SalesProcessor;
import java.util.Scanner;

public class UserInterface {
    private final Inventory inventory;
    private final SupplierInformation supplierInformation;
    private final PurchasesProcessor purchasesProcessor;
    private final SalesProcessor salesProcessor;
    private final Scanner scanner = new Scanner(System.in);

    public UserInterface(Inventory inventory, SupplierInformation supplierInformation) {
        this.inventory = inventory;
        this.supplierInformation = supplierInformation;
        this.purchasesProcessor = new PurchasesProcessor(inventory);
        this.salesProcessor = new SalesProcessor(inventory);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> manageInventory();
                case "2" -> processSupplierOrder();
                case "3" -> processCustomerOrder();
                case "4" -> manageSuppliers();
                case "0" -> exit = true;
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nWarehouse Management System");
        System.out.println("1. Inventory Management");
        System.out.println("2. Process Supplier Order (Purchases)");
        System.out.println("3. Process Customer Order (Sales)");
        System.out.println("4. Manage Suppliers");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    private void manageSuppliers() {
        SupplierManager sm = new SupplierManager(supplierInformation);
        sm.run();
    }

    private void manageInventory() {
        InventoryManager im = new InventoryManager(inventory);
        im.run();
    }

    private void processSupplierOrder() {
        PurchasesManager pp = new PurchasesManager(supplierInformation ,inventory);
        pp.run();
    }

    private void processCustomerOrder() {
        SalesManager sm = new SalesManager(inventory, salesProcessor);
        sm.run();
    }

}
