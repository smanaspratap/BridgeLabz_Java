package JavaGenerics;
/*2. Dynamic Online Marketplace
Concepts: Type Parameters, Generic Methods, Bounded Type Parameters
Problem Statement:
Build a generic product catalog for an online marketplace that supports various product types like Books, Clothing, and Gadgets. Each product type has a specific price range and category.
Hints:
Define a generic class Product<T> where T is restricted to a category (BookCategory, ClothingCategory, etc.).
Implement a generic method to apply discounts dynamically (<T extends Product> void applyDiscount(T product, double percentage)).
Ensure type safety while allowing multiple product categories to exist in the same catalog.
*/
// DynamicMarketplace.java
import java.util.*;

// Marker interface for product categories
interface Category { String getCategoryName(); }

class BookCategory implements Category {
    public String getCategoryName() { return "Books"; }
}

class ClothingCategory implements Category {
    public String getCategoryName() { return "Clothing"; }
}

class GadgetCategory implements Category {
    public String getCategoryName() { return "Gadgets"; }
}

// Generic product class restricted to Category types
class Product<T extends Category> {
    private final String id;
    private final String name;
    private double price; // price in currency units
    private final T category;

    public Product(String id, String name, double price, T category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public T getCategory() { return category; }

    public void setPrice(double newPrice) { this.price = newPrice; }

    @Override
    public String toString() {
        return String.format("%s[%s] - %.2f (%s)", name, id, price, category.getCategoryName());
    }
}

// Generic method to apply discount to a product (works for any Product<T>)
class DiscountUtil {
    // T is any Product whose type parameter extends Category
    public static <T extends Product<? extends Category>> void applyDiscount(T product, double percentage) {
        if (percentage < 0 || percentage > 100) throw new IllegalArgumentException("Invalid percentage");
        double newPrice = product.getPrice() * (1 - percentage / 100.0);
        product.setPrice(Math.round(newPrice * 100.0) / 100.0); // round to 2 decimals
    }
}

// Catalog that can hold products of mixed categories using wildcard types
class Catalog {
    private final List<Product<? extends Category>> products = new ArrayList<>();

    public void add(Product<? extends Category> p) {
        products.add(p);
    }

    public List<Product<? extends Category>> getProducts() {
        return Collections.unmodifiableList(products);
    }

    // Display all products (read-only)
    public void showAll() {
        for (Product<? extends Category> p : products) {
            System.out.println(p);
        }
    }
}

// Demo
public class DynamicMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("B001", "Intro to Java", 499.0, new BookCategory());
        Product<ClothingCategory> tshirt = new Product<>("C001", "Plain Tee", 799.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("G001", "Smartphone X", 29999.0, new GadgetCategory());

        Catalog catalog = new Catalog();
        catalog.add(book);
        catalog.add(tshirt);
        catalog.add(phone);

        System.out.println("Catalog before discounts:");
        catalog.showAll();

        // Apply discount using generic method
        DiscountUtil.applyDiscount(book, 10);  // 10% off on book
        DiscountUtil.applyDiscount(phone, 5);  // 5% off on gadget

        System.out.println("\nCatalog after discounts:");
        catalog.showAll();
    }
}
