package org.example.People;
import org.example.ProductManagement.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Supplier extends Person {
    private List<Product> availableProducts = new ArrayList<>();
    // private List<SupplierOrder> orderHistory;

    public Supplier(String name, String phoneNumber, String email, String address) {
        super("SUP-" + UUID.randomUUID().toString());
        this.name = name;
        this.contactInfo = new ContactInfo(email, phoneNumber, address);
    }

    public Product getProductsList(int i) {
        return availableProducts.get(i);
    }

    public void addProduct(Product product) {
        String productId = id + " :: " + product.getProductName();
        product.setProductId(productId);
        availableProducts.add(product);
    }

    public void removeProduct(Product product) {
        availableProducts.remove(product);
    }
}
