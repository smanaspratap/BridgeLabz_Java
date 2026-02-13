package JavaGenerics;
/*1. Smart Warehouse Management System
Concepts: Generic Classes, Bounded Type Parameters, Wildcards
Problem Statement:
You are developing a Smart Warehouse System that manages different types of items like Electronics, Groceries, and Furniture. The system should be able to store and retrieve items dynamically while maintaining type safety.
Hints:
Create an abstract class WarehouseItem that all items extend (Electronics, Groceries, Furniture).
Implement a generic class Storage<T extends WarehouseItem> to store items safely.
Implement a wildcard method to display all items in storage regardless of their type (List<? extends WarehouseItem>).
*/
// SmartWarehouse.java
import java.util.*;

// Abstract base class for all items stored in the warehouse
abstract class WarehouseItem {
    private final String id;
    private final String name;

    public WarehouseItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id=" + id + ", name=" + name + "}";
    }
}

// Concrete item types
class Electronics extends WarehouseItem {
    private final int warrantyMonths;
    public Electronics(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }
    public int getWarrantyMonths() { return warrantyMonths; }
}

class Groceries extends WarehouseItem {
    private final Date expiry;
    public Groceries(String id, String name, Date expiry) {
        super(id, name);
        this.expiry = expiry;
    }
    public Date getExpiry() { return expiry; }
}

class Furniture extends WarehouseItem {
    private final String material;
    public Furniture(String id, String name, String material) {
        super(id, name);
        this.material = material;
    }
    public String getMaterial() { return material; }
}

// Generic storage restricted to WarehouseItem and its subclasses
class Storage<T extends WarehouseItem> {
    private final List<T> items = new ArrayList<>();

    // Add an item to storage
    public void add(T item) {
        items.add(item);
    }

    // Remove an item (by object)
    public boolean remove(T item) {
        return items.remove(item);
    }

    // Return unmodifiable view for safety
    public List<T> getItems() {
        return Collections.unmodifiableList(items);
    }
}

// Utility containing wildcard method to display any WarehouseItem lists
class WarehouseUtils {
    // Accepts any list whose element type is WarehouseItem or its subclass (read-only usage)
    public static void displayAllItems(List<? extends WarehouseItem> list) {
        System.out.println("Displaying items:");
        for (WarehouseItem it : list) {
            System.out.println(" - " + it);
        }
    }
}

// Demo
public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.add(new Electronics("E001", "Bluetooth Speaker", 24));
        electronicsStorage.add(new Electronics("E002", "Smartphone", 12));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.add(new Groceries("G001", "Milk", new Date(System.currentTimeMillis() + 3L*24*3600*1000))); // +3 days

        // Using wildcard display method to show contents of different storages
        WarehouseUtils.displayAllItems(electronicsStorage.getItems());
        WarehouseUtils.displayAllItems(groceriesStorage.getItems());

        // You cannot add generic-incompatible items to a Storage<Electronics>
        // electronicsStorage.add(new Groceries(...)); // compile-time error -> type safety
    }
}

