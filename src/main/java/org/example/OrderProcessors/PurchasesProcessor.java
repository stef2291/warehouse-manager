package org.example.OrderProcessors;

import org.example.Database.Inventory;
import org.example.Supplier.*;
import java.util.ArrayList;
import java.util.List;

public class PurchasesProcessor {
    private final Inventory inventory;
    private final List<SupplierOrder> processedOrders = new ArrayList<>();
    private double totalPurchaseCost = 0.0;

    public PurchasesProcessor(Inventory inventory) {
        this.inventory = inventory;
    }

    public void processOrder(SupplierOrder order) {
        if (order == null || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Invalid supplier order.");
        }

        for (SupplierOrderProduct orderProduct : order.getProducts()) {
            Product newProduct = findProductByName(order.getSupplier(), orderProduct.getProduct());

            if (newProduct == null) {
                System.out.println("Product not found in supplier's catalog: " + orderProduct.getProduct());
                continue;
            }

            Product inventoryProduct = inventory.getProduct(newProduct.getProductId());
            if (inventoryProduct != null) {
                int updatedQuantity = inventoryProduct.getQuantity() + orderProduct.getQuantity();
                inventory.updateQuantity(newProduct.getProductId(), updatedQuantity);
            } else {
                Product copy = new Product(newProduct.getProductName(), newProduct.getPrice(), orderProduct.getQuantity(), newProduct.getThreshold());
                copy.setProductId(newProduct.getProductId());
                inventory.addProduct(copy);
            }

            totalPurchaseCost += newProduct.getPrice() * orderProduct.getQuantity();
        }

        order.setStatus(SupplierOrder.Status.RECEIVED);
        processedOrders.add(order);
    }

    private Product findProductByName(Supplier supplier, String productName) {
        for (int i = 0; ; i++) {
            try {
                Product p = supplier.getProductsList(i);
                if (p.getProductName().equals(productName)) return p;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
    }

    public double getTotalPurchaseCost() {
        return totalPurchaseCost;
    }

    public List<SupplierOrder> getProcessedOrders() {
        return processedOrders;
    }
}

