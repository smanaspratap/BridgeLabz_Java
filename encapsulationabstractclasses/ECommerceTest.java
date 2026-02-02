/*
2. E-Commerce Platform
Description: Develop a simplified e-commerce platform:
Create an abstract class Product with fields like productId, name, and price,
and an abstract method calculateDiscount().
Extend it into concrete classes: Electronics, Clothing, and Groceries.
Implement an interface Taxable with methods calculateTax() and getTaxDetails()
for applicable product categories.
Use encapsulation to protect product details, allowing updates only through setter methods.
Showcase polymorphism by creating a method that calculates and prints the final price
(price + tax - discount) for a list of Product.
*/

import java.util.ArrayList;
import java.util.List;

/* ---------- Interface ---------- */
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

/* ---------- Abstract Class ---------- */
abstract class Product {

    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();

    // Encapsulation (Getters & Setters)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
}

/* ---------- Electronics ---------- */
class Electronics extends Product implements Taxable {

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    @Override
    public String getTaxDetails() {
        return "18% GST";
    }
}

/* ---------- Clothing ---------- */
class Clothing extends Product implements Taxable {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% tax
    }

    @Override
    public String getTaxDetails() {
        return "12% GST";
    }
}

/* ---------- Groceries ---------- */
class Groceries extends Product {

    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

/* ---------- Main Class ---------- */
public class ECommerceTest {

    // Polymorphism method
    static void printFinalPrices(List<Product> products) {

        for (Product p : products) {

            double tax = 0;
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
            }

            double finalPrice = p.getPrice() + tax - p.calculateDiscount();

            System.out.println(p.getName() + " Final Price: " + finalPrice);
        }
    }

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Electronics(1, "Laptop", 60000));
        products.add(new Clothing(2, "Shirt", 2000));
        products.add(new Groceries(3, "Rice", 1000));

        printFinalPrices(products);
    }
}
