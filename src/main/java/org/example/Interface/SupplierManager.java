package org.example.Interface;
import org.example.Supplier.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupplierManager {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Supplier> supplierList= new ArrayList<>();

    public void run() {
        while (true) {
            System.out.println("\n--- Supplier Management ---");
            System.out.println("1. View Suppliers");
            System.out.println("2. Add Supplier");
            System.out.println("3. Modify Supplier");
            System.out.println("4. Delete Supplier");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": viewSuppliers(); break;
                case "2": addSupplier(); break;
                case "3": modifySupplier(); break;
                case "4": deleteSupplier(); break;
                case "5": return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void viewSuppliers() {
        if (supplierList.isEmpty()) {
            System.out.println("No suppliers found.");
            return;
        }

        System.out.println("\n--- Suppliers ---");
        for (int i = 0; i < supplierList.size(); i++) {
            Supplier s = supplierList.get(i);
            System.out.println((i + 1) + ". " + s.getName() + " (" + s.getSupplierID() + ")");
            System.out.println("   " + s.getContactInfo());
        }
    }

    private void addSupplier() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Supplier supplier = new Supplier(name, phone, email, address);
        supplierList.add(supplier);
        System.out.println("Supplier added: " + supplier.getName());
    }

    private void deleteSupplier() {
        viewSuppliers();
        if (supplierList.isEmpty()) return;

        System.out.print("Enter supplier number to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index < 0 || index >= supplierList.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Supplier removed = supplierList.remove(index);
        System.out.println("Removed supplier: " + removed.getName());
    }

    private String requestUpdate(String label, String currentValue) {
        System.out.print("Would you like to change Supplier " + label + " ? Y/n (current:) " + currentValue + "): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Y")) {
            System.out.print("Enter new " + label + ": ");
        return scanner.nextLine();
        }
        return null;
    }

    private void modifySupplier() {
        viewSuppliers();
        if (supplierList.isEmpty()) return;

        System.out.print("Enter supplier number to modify: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index < 0 || index >= supplierList.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Supplier s = supplierList.get(index);

        String newName = requestUpdate("Name",s.getName());
        if(newName != null) s.setName(newName);

        String newEmail = requestUpdate("Email",s.getContactInfo(Supplier.ContactDetails.EMAIL));
        if(newEmail != null) s.updateContactInfo().setEmail(newEmail);

        String newPhone = requestUpdate("Phone Number",s.getContactInfo(Supplier.ContactDetails.PHONE));
        if(newPhone != null) s.updateContactInfo().setPhoneNumber(newPhone);

        String newAddress = requestUpdate("Address",s.getContactInfo(Supplier.ContactDetails.ADDRESS));
        if(newAddress != null) s.updateContactInfo().setAddress(newAddress);

        System.out.println("Supplier updated.");
    }
}
