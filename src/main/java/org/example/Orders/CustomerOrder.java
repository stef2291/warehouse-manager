package org.example.Orders;

import org.example.People.Customer;
import org.example.ProductManagement.CustomerOrderProduct;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrder extends Order {

    private final Customer customer;
    private final List<CustomerOrderProduct> products = new ArrayList<>();

    public CustomerOrder(Customer customer) {
        super("SALE-" + customer.getId());
        this.customer = customer;
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
