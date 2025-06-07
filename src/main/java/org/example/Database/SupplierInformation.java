package org.example.Database;

import org.example.Supplier.Supplier;
import java.util.ArrayList;
import java.util.List;

public class SupplierInformation {
    private final List<Supplier> supplierList = new ArrayList<>();

    public void addSupplier(Supplier supplier) {
        supplierList.add(supplier);
    }

    public Supplier getSupplier(int index) {
        return supplierList.get(index);
    }

    public void removeSupplier(int index) {
        supplierList.remove(index);
    }

    public List<Supplier> getAllSuppliers() {
        return new ArrayList<>(supplierList); //Defensive copy
    }
}
