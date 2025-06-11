package org.example.OrderProcessors;

import org.example.Orders.CustomerOrder;
import org.example.ProductManagement.CustomerOrderProduct;
import org.example.Database.Inventory;
import org.example.ProductManagement.Product;
import java.util.ArrayList;
import java.util.List;

public class SalesProcessor {
    private final Inventory inventory;
    private final List<CustomerOrder> processedOrders = new ArrayList<>();
    private double totalSalesRevenue = 0.0;

    public SalesProcessor(Inventory inventory) {
        this.inventory = inventory;
    }

    public void processOrder(CustomerOrder order) {
        int i = 0;
        if (order == null || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Invalid customer order.");
        }

        for (CustomerOrderProduct orderProduct : order.getProducts()) {
            Product product = inventory.getProduct(orderProduct.getProduct().getProductName());

            if (product == null) {
                System.out.println("Order failed: Product " + orderProduct.getProduct().getProductName() + " not recognised");
                i++;
                continue;
            }else if(product.getQuantity() < orderProduct.getQuantity()) {
                System.out.println("Insufficient stock for " +
                        orderProduct.getProduct().getProductName());
                i++;
                continue;
            }

            int updatedQuantity = product.getQuantity() - orderProduct.getQuantity();
            inventory.updateQuantity(product.getProductName(), updatedQuantity);
            totalSalesRevenue += product.getPrice() * orderProduct.getQuantity();
        }

        if(i == order.getProducts().size()) {
            order.setStatus(CustomerOrder.Status.CANCELLED);
            return;
        } else if(i > 0 && i < order.getProducts().size()) {
            order.setStatus(CustomerOrder.Status.PARTIAL);
            processedOrders.add(order);
            return;
        }
        order.setStatus(CustomerOrder.Status.DELIVERED);
        processedOrders.add(order);
    }

    public double getTotalSalesRevenue() {
        return totalSalesRevenue;
    }

    public List<CustomerOrder> getProcessedOrders() {
        return processedOrders;
    }
}
