package org.example.Customer;

import org.example.Supplier.Product;

public class CustomerOrderProduct {
    private Product product;
    private int quantity;

    public CustomerOrderProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return product.getProductName() + " (Qty: " + quantity + ")";
    }
}
