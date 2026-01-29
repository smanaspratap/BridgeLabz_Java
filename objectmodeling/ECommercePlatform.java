/* Problem 4: E-commerce Platform with Orders, Customers, and Products
Description:
A Customer places Orders.
Each Order contains multiple Products.

Goal:
Show communication and aggregation using real-world example.
*/

import java.util.ArrayList;

// Product class
class Product {
    String productName;
    double price;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
}

// Order class (aggregates Products)
class Order {
    int orderId;
    ArrayList<Product> products;

    Order(int orderId) {
        this.orderId = orderId;
        products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        for (Product p : products) {
            System.out.println(p.productName + " - ₹" + p.price);
        }
    }
}

// Customer class
class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    // Communication through Order
    void placeOrder(Order order) {
        System.out.println(name + " placed an order.");
        order.showOrderDetails();
    }
}

// Main class
public class ECommercePlatform {
    public static void main(String[] args) {

        Customer c = new Customer("Manas");

        Product p1 = new Product("Laptop", 60000);
        Product p2 = new Product("Mouse", 500);

        Order order = new Order(101);
        order.addProduct(p1);
        order.addProduct(p2);

        c.placeOrder(order);
    }
}
