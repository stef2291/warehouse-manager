package org.example.Orders;

import org.example.ProductManagement.SupplierOrderProduct;
import org.example.People.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierOrder extends Order {
    private final Supplier supplier;
    private final List<SupplierOrderProduct> products = new ArrayList<>();

    public SupplierOrder(Supplier supplier) {
        super("PURCH-" + supplier.getId());
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void removeProduct(SupplierOrderProduct product) {
        products.remove(product);
    }

    public void addProducts(SupplierOrderProduct product) {
        products.add(product);
    }

    public List<SupplierOrderProduct> getProducts() {
        return products;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder orderInfo = new StringBuilder("Supplier Order ID: " + orderId + "\n");
        orderInfo.append("Supplier: ").append(supplier.getName()).append("\n");
        orderInfo.append("Order Date: ").append(orderDate).append("\n");
        orderInfo.append("Status: ").append(status).append("\n");
        orderInfo.append("Products:\n");

        for (SupplierOrderProduct item : products) {
            orderInfo.append("- ").append(item.getProduct().getProductName())
                    .append(" (Qty: ").append(item.getQuantity()).append(")\n");
        }

        return orderInfo.toString();
    }
}
