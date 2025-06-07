package org.example.Database;

import org.example.Supplier.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Inventory {
    private Map<String, Product> productTracker = new HashMap<>();

    public void addProduct(Product product) {
        productTracker.put(product.getProductName(), product);
    }

    public Product getProduct(String productName) {
        return productTracker.get(productName);
    }

    public void updateQuantity(String productName, int quantity) {
        Product product = productTracker.get(productName);
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
