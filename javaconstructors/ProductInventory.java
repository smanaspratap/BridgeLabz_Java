/*Problem 1: Product Inventory
Create a Product class with:
Instance Variables: productName, price.
Class Variable: totalProducts (shared among all products).
Methods:
An instance method displayProductDetails() to display the details of a product.
A class method displayTotalProducts() to show the total number of products created.
 */

class Product {
    String productName;
    double price;

    static int totalProducts = 0; // class variable

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    // Class method
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 60000);
        Product p2 = new Product("Mobile", 25000);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();

        Product.displayTotalProducts();
    }
}

