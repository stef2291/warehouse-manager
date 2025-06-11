package org.example.ProductManagement;

public abstract class OrderProduct {
    protected Product product;
    protected int quantity;

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
