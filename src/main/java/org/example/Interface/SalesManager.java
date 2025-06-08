package org.example.Interface;

import org.example.Customer.Customer;
import org.example.Customer.CustomerOrder;
import org.example.Customer.CustomerOrderProduct;
import org.example.Database.Inventory;
import org.example.OrderProcessors.SalesProcessor;
import org.example.Supplier.Product;

import java.util.Scanner;

public class SalesManager {
    private final Inventory inventory;
    private final SalesProcessor salesProcessor;
    private final Scanner scanner = new Scanner(System.in);

    public SalesManager(Inventory inventory, SalesProcessor salesProcessor) {
        this.inventory = inventory;
        this.salesProcessor = salesProcessor;
    }
    public void run() {
        while (true) {
            System.out.println("\n--- Sales Management ---");
            System.out.println("1. Create Customer Order");
            System.out.println("2. View Processed Orders");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> createOrder();
                case "2" -> viewProcessedOrders();
                case "3" -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void createOrder() {
        System.out.println("--- Create Customer Order ---");

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(name, email, phone, address);
        CustomerOrder order = new CustomerOrder(customer);

        while (true) {
            System.out.print("Enter product name (or 'done'): ");
            String nameInput = scanner.nextLine();
            if (nameInput.equalsIgnoreCase("done")) break;

            Product product = inventory.getProduct(nameInput);
            if (product == null) {
                System.out.println("Product not found.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity;
            try {
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity.");
                continue;
            }

            order.addProduct(new CustomerOrderProduct(product, quantity));
        }

        if (order.getProducts().isEmpty()) {
            System.out.println("No products selected. Order cancelled.");
            return;
        }

        salesProcessor.processOrder(order);
        System.out.println("Order processed. Status: " + order.getStatus());
    }

    private void viewProcessedOrders() {
        var orders = salesProcessor.getProcessedOrders();
        if (orders.isEmpty()) {
            System.out.println("No sales orders processed.");
            return;
        }

        for (CustomerOrder order : orders) {
            System.out.println(order);
        }

        System.out.printf("Total Sales Revenue: £%.2f\n", salesProcessor.getTotalSalesRevenue());
    }

}
