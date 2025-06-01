package org.example.Customer;

import java.util.UUID;
import org.example.Supplier.ContactInfo;

public class Customer {
    private String customerId;
    private String name;
    private ContactInfo contactInfo;

    public Customer(String name, String email, String phoneNumber, String address) {
        this.customerId = UUID.randomUUID().toString();
        this.name = name;
        this.contactInfo = new ContactInfo(email, phoneNumber, address);
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactInfo getContactInfo() {
        return this.contactInfo;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId +
                "\nName: " + name +
                "\nContact Info:\n" + contactInfo.toString();
    }
}
