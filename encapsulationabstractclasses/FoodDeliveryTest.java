/*
Description: Create an online food delivery system:
Define an abstract class FoodItem with fields like itemName, price, and quantity.
Add abstract methods calculateTotalPrice() and concrete methods like getItemDetails().
Extend it into classes VegItem and NonVegItem, overriding calculateTotalPrice()
to include additional charges (e.g., for non-veg items).
Use an interface Discountable with methods applyDiscount() and getDiscountDetails().
Demonstrate encapsulation to restrict modifications to order details and
use polymorphism to handle different types of food items in a single order-processing method.
*/

import java.util.ArrayList;
import java.util.List;

/* ---------- Interface ---------- */
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

/* ---------- Abstract Class ---------- */
abstract class FoodItem {

    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item     : " + itemName);
        System.out.println("Price    : " + price);
        System.out.println("Quantity : " + quantity);
    }

    // Encapsulation (getters only)
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

/* ---------- Veg Item ---------- */
class VegItem extends FoodItem implements Discountable {

    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "10% Veg Discount";
    }
}

/* ---------- Non-Veg Item ---------- */
class NonVegItem extends FoodItem implements Discountable {

    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 50; // extra charge
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "5% Non-Veg Discount";
    }
}

/* ---------- Main Class ---------- */
public class FoodDeliveryTest {

    // Polymorphic order processing method
    static void processOrder(List<FoodItem> items) {

        for (FoodItem item : items) {

            item.getItemDetails();

            double total = item.calculateTotalPrice();
            double discount = 0;

            if (item instanceof Discountable) {
                discount = ((Discountable) item).applyDiscount();
            }

            double finalAmount = total - discount;

            System.out.println("Total Price : " + total);
            System.out.println("Discount    : " + discount);
            System.out.println("Final Amount: " + finalAmount);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {

        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Biryani", 180, 2));
        order.add(new NonVegItem("Chicken Biryani", 250, 1));

        processOrder(order);
    }
}
