package org.example;
import org.example.Interface.UserInterface;
import org.example.Database.Inventory;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        if (args.length > 0 && args[0].equalsIgnoreCase("createStubs")) {
            org.example.Stubs.StubData.populate(inventory);
            System.out.println("Stub data loaded successfully.");
        }

        UserInterface ui = new UserInterface(inventory);
        ui.run();
    }
}