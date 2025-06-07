//package org.example.Database;
//import org.example.Supplier.Product;
//import org.example.Supplier.Supplier;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Database {
//    private final Inventory inventory = new Inventory();
//    private final List<Supplier> suppliers = new ArrayList<>();
//
//    public Inventory getInventory() {
//        return inventory;
//    }
//
//    public void addSupplier(Supplier supplier) {
//        suppliers.add(supplier);
//    }
//
//    public List<Supplier> getSuppliers() {
//        return suppliers;
//    }
//
//    public Supplier getSupplierById(String id) {
//        return suppliers.stream()
//                .filter(s -> s.getSupplierID().equals(id))
//                .findFirst()
//                .orElse(null);
//    }
//}
