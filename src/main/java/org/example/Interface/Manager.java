package org.example.Interface;

import java.util.Scanner;

public abstract class Manager {
    protected final Scanner scanner;

    public Manager(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void run();

    protected double promptForDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());

            }catch (NumberFormatException error) {
                System.out.println("Invalid number. Please enter a valid decimal number.");
            }
        }
    }

    protected int promptForInteger() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());

            }catch (NumberFormatException error) {
                System.out.println("Invalid number. Please enter a valid decimal number.");
            }
        }
    }

}
