/*Program to Simulate a Shopping Cart
Problem Statement: Create a CartItem class with attributes itemName, price, and quantity. Add methods to:
Add an item to the cart.
Remove an item from the cart.
Display the total cost.
Explanation: The CartItem class models a shopping cart item. The methods handle cart operations like adding or removing items and calculating the total cost.
 */

class CartItem {
    // Attributes
    String itemName;
    double price;
    int quantity;

    // Constructor
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add items
    void addItem(int qty) {
        quantity += qty;
        System.out.println(qty + " items added to the cart.");
    }

    // Method to remove items
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println(qty + " items removed from the cart.");
        } else {
            System.out.println("Not enough items to remove.");
        }
    }

    // Method to display total cost
    void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.println("Item Name  : " + itemName);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Total Cost : ₹" + totalCost);
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        CartItem item = new CartItem("Notebook", 50, 2);

        item.addItem(3);
        item.removeItem(1);
        item.displayTotalCost();
    }
}
