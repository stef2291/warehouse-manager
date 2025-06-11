package org.example.OrderProcessors;

import org.example.Database.Inventory;
import org.example.Orders.SupplierOrder;
import org.example.ProductManagement.Product;
import org.example.ProductManagement.SupplierOrderProduct;
import org.example.People.*;
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
            Product productFromSupplierList = findProductByName(order.getSupplier(), orderProduct.getProduct());

            if (productFromSupplierList == null) {
                System.out.println("Product not found in supplier's catalog: " + orderProduct.getProduct());
                continue;
            }

            Product inventoryProduct = inventory.getProduct(productFromSupplierList.getProductName());
            if (inventoryProduct != null) {
                int updatedQuantity = inventoryProduct.getQuantity() + orderProduct.getQuantity();
                inventory.updateQuantity(productFromSupplierList.getProductName(), updatedQuantity);

            } else {
                Product newProductInInventory = new Product(productFromSupplierList.getProductName(), productFromSupplierList.getPrice(), orderProduct.getQuantity(), productFromSupplierList.getThreshold());
                newProductInInventory.setProductId(productFromSupplierList.getProductId());
                inventory.addProduct(newProductInInventory);
            }

            totalPurchaseCost += productFromSupplierList.getPrice() * orderProduct.getQuantity();
        }

        order.setStatus(SupplierOrder.Status.RECEIVED);
        processedOrders.add(order);
    }

    private Product findProductByName(Supplier supplier, Product product) {
        for (int i = 0; ; i++) {
            try {
                Product p = supplier.getProductsList(i);
                if (p.getProductName().equals(product.getProductName())) return p;
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

