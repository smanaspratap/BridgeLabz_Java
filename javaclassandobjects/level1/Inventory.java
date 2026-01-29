/*Program to Track Inventory of Items
Problem Statement: Create an Item class with attributes itemCode, itemName, and price. Add a method to display item details
and calculate the total cost for a given quantity.
 */
import java.util.Scanner;

class Item {
    int itemCode;
    String itemName;
    int price;

    // Constructor
    Item(int itemCode, String itemName, int price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Display item details
    public void display() {
        System.out.println("Item Code  : " + itemCode);
        System.out.println("Item Name  : " + itemName);
        System.out.println("Item Price : " + price);
    }

    // Calculate total cost
    public int totalCost(int quantity) {
        return price * quantity;
    }
}

public class Inventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter item code:");
        int code = sc.nextInt();

        System.out.println("Enter item name:");
        String name = sc.next();

        System.out.println("Enter item price:");
        int price = sc.nextInt();

        System.out.println("Enter quantity:");
        int quantity = sc.nextInt();

        Item item1 = new Item(code, name, price);

        System.out.println("\n--- Item Details ---");
        item1.display();

        System.out.println("Total Cost : " + item1.totalCost(quantity));

        sc.close();
    }
}

