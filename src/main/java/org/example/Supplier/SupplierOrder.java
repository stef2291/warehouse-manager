package org.example.Supplier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SupplierOrder {
    private String orderId;
    private Supplier supplier;
    private List<SupplierOrderProduct> products = new ArrayList<>();
    private LocalDate orderDate;
    private Status status;
    public enum Status {APPROVED, CANCELLED, PENDING,RECEIVED, OTHER}

    public SupplierOrder(Supplier supplier) {
        this.orderId = UUID.randomUUID().toString();
        this.supplier = supplier;
        this.orderDate = LocalDate.now();
        this.status = Status.PENDING;
    }

    public String getOrderId() {
        return this.orderId;
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

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public Status getStatus() {
        return this.status;
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
            orderInfo.append("- ").append(item.getProduct())
                    .append(" (Qty: ").append(item.getQuantity()).append(")\n");
        }

        return orderInfo.toString();
    }
}
