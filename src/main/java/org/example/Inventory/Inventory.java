package org.example.Inventory;

import org.example.Supplier.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Inventory {
    private Map<String, Product> productTracker = new HashMap<>();

    public void addProduct(Product product) {
        productTracker.put(product.getProductId(), product);
        System.out.println("Product :: " + productTracker.get(product.getProductId()).getProductName());
    }

    public Product getProduct(String productId) {
        System.out.println("Product ID :: " + productId);
        return productTracker.get(productId);
    }

    public void updateQuantity(String productId, int quantity) {
        Product product = productTracker.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
        }
    }

    public Map<String, Product> getAllProducts() {
        return productTracker;
    }

    public List<Product> lowStockAlert() {
        List<Product> lowStock = new ArrayList<>();
        for (Product product : productTracker.values()) {
            if (product.getQuantity() <= product.getThreshold()) {
                lowStock.add(product);
            }
        }
        return lowStock;
    }
}
