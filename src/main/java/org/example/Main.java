package org.example;

import org.example.Supplier.Product;
import org.example.Supplier.Supplier;

public class Main {
    public static void main(String[] args) {
         Supplier primark = new Supplier("Primark", "020111222", "primark@gmail.com", "22 Primark Avenue");
            Product tshirt = new Product("tshirt", 12.99, 12);

            primark.addProduct(tshirt);
            System.out.println(primark.getName());
            System.out.println(primark.getContactInfo(Supplier.ContactDetails.ADDRESS));
            System.out.println(primark.getProductsList(0).getProductName() + " :: Product ID :: " + tshirt.getProductId());
        }
    }
}