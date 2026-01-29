/*
Sample Program 4: Shopping Cart System
Uses static discount, final productID, this, and instanceof.
*/

class Product {

    // Static variable
    static double discount = 10.0;

    // Final variable
    final int productID;

    // Instance variables
    String productName;
    double price;
    int quantity;

    // Constructor using this
    Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayProductDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
    }

    public static void main(String[] args) {
        Product p = new Product(1001, "Laptop", 60000, 1);

        if (p instanceof Product) {
            p.displayProductDetails();
        }
    }
}
