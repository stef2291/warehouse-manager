package org.example.Supplier;

public class ContactInfo {
    private String email;
    private String phoneNumber;
    private String address;


    public ContactInfo(ContactInfo source) {
        setEmail(source.email);
        setPhoneNumber(source.phoneNumber);
        setAddress(source.address);
    }

    public ContactInfo(String email, String phoneNumber, String address) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Email : " + getEmail() + "\nAddress : " + getAddress() + "\nPhone Number : " + getPhoneNumber();
    }
}
