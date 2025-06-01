package org.example.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Supplier {

    private String supplierID;
    private String name;
    private ContactInfo contactInfo;
    public enum ContactDetails {EMAIL, PHONE, ADDRESS, ALL} // Create drop box with available choices
    private List<Product> availableProducts = new ArrayList<>();
    // private List<SupplierOrder> orderHistory;

    public Supplier(String name, String phoneNumber, String email, String address) {
        this.supplierID = UUID.randomUUID().toString();
        this.name = name;
        this.contactInfo = new ContactInfo(email, phoneNumber, address);
    }

    public String getSupplierID() {
        return this.supplierID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return this.contactInfo.toString();
    }

    public String getContactInfo(ContactDetails type) {
        switch (type) {

            case EMAIL:
                return this.contactInfo.getEmail();

            case PHONE:
                return this.contactInfo.getPhoneNumber();

            case ADDRESS:
                return this.contactInfo.getAddress();

            default:
                return "The type of information you requested is not available!";
        }
    }

    public Product getProductsList(int i) {
        return availableProducts.get(i);
    }

    public void addProduct(Product product) {
        String productId = supplierID + " :: " + product.getProductName();
        product.setProductId(productId);
        availableProducts.add(product);
    }

    public void removeProduct(Product product) {
        availableProducts.remove(product);
    }
}
