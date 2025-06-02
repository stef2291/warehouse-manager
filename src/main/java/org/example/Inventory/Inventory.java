package org.example.Inventory;

import org.example.Supplier.Product;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> productTracker = new HashMap<>();

    public void addProduct(Product product) {
        productTracker.put(product.getProductId(), product);
    }

    public Product getProduct(String productId) {
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
}
