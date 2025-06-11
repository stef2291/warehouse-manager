package org.example.People;

import java.util.UUID;

public class Customer extends Person {

    public Customer(String name, String email, String phoneNumber, String address) {
        super("CUS-"+UUID.randomUUID().toString());
        this.name = name;
        this.contactInfo = new ContactInfo(email, phoneNumber, address);
    }

    @Override
    public String toString() {
        return "Customer ID: " + id +
                "\nName: " + name +
                "\nContact Info:\n" + contactInfo.toString();
    }
}
