package org.example.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerOrder {

    private String orderId;
    private Customer customer;
    private List<CustomerOrderProduct> products = new ArrayList<>();
    private LocalDate orderDate;
    private Status status;

    public enum Status {
        PENDING, APPROVED, SHIPPED, DELIVERED, CANCELLED
    }

    public CustomerOrder(Customer customer) {
        this.orderId = UUID.randomUUID().toString();
        this.customer = customer;
        this.orderDate = LocalDate.now();
        this.status = Status.PENDING;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<CustomerOrderProduct> getProducts() {
        return this.products;
    }

    public void addProduct(CustomerOrderProduct product) {
        products.add(product);
    }

    public void removeProduct(CustomerOrderProduct product) {
        products.remove(product);
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
        StringBuilder orderDetails = new StringBuilder("Customer Order ID: " + orderId + "\n");
        orderDetails.append("Customer: ").append(customer.getName()).append("\n");
        orderDetails.append("Order Date: ").append(orderDate).append("\n");
        orderDetails.append("Status: ").append(status).append("\n");
        orderDetails.append("Products:\n");

        for (CustomerOrderProduct item : products) {
            orderDetails.append("- ").append(item.toString()).append("\n");
        }

        return orderDetails.toString();
    }
}
