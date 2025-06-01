package org.example.Supplier;

public class SupplierOrderProduct {
    private String product;
    private int quantity;

    public SupplierOrderProduct(Product product, int quantity) {
        this.product = product.getProductName();
        this.quantity = quantity;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
