package org.example.ProductManagement;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private int threshold;

    public Product(String productName, double price, int quantity, int threshold) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.threshold = threshold;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getThreshold() {
        return this.threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
