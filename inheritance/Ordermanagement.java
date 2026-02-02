/*Sample Problem 1: Online Retail Order Management 
○ Description: Create a multilevel hierarchy to manage orders, where Order is 
the base class, ShippedOrder is a subclass, and DeliveredOrder extends 
ShippedOrder. 
○ Tasks: 
■ Define a base class Order with common attributes like orderId and 
orderDate. 
■ Create a subclass ShippedOrder with additional attributes like 
trackingNumber. 
■ Create another subclass DeliveredOrder extending ShippedOrder, 
adding a deliveryDate attribute. 
■ Implement a method getOrderStatus() to return the current order 
status based on the class level. 
○ Goal: Explore multilevel inheritance, showing how attributes and methods can be 
added across a chain of classes.  */

// Base class
class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }
}

// Subclass 1
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped";
    }
}

// Subclass 2 (multilevel)
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered";
    }
}

// Main class
public class Ordermanagement {
    public static void main(String[] args) {

        Order o1 = new Order(101, "01-Feb-2026");
        Order o2 = new ShippedOrder(102, "02-Feb-2026", "TRK12345");
        Order o3 = new DeliveredOrder(103, "03-Feb-2026", "TRK67890", "05-Feb-2026");

        System.out.println("Order 1 Status: " + o1.getOrderStatus());
        System.out.println("Order 2 Status: " + o2.getOrderStatus());
        System.out.println("Order 3 Status: " + o3.getOrderStatus());
    }
}
