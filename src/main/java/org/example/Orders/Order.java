package org.example.Orders;
import java.time.LocalDate;

public abstract class Order {
    protected final String orderId;
    protected final LocalDate orderDate;
    protected Status status;

    public enum Status {
        PENDING, APPROVED, DELIVERED, RECEIVED, PARTIAL , CANCELLED
    }

    public Order(String orderId) {
        this.orderId = orderId;
        this.orderDate = LocalDate.now();
        this.status = Status.PENDING;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public Status getStatus() {
        return this.status;
    }


}
