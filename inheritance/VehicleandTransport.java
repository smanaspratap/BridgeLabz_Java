/*Vehicle and Transport System 
○ Description: Design a vehicle hierarchy where Vehicle is the superclass, and 
Car, Truck, and Motorcycle are subclasses with unique attributes. 
○ Tasks: 
■ Define a superclass Vehicle with maxSpeed and fuelType attributes 
and a method displayInfo(). 
■ Define subclasses Car, Truck, and Motorcycle, each with additional 
attributes, such as seatCapacity for Car. 
■ Demonstrate polymorphism by storing objects of different subclasses in 
an array of Vehicle type and calling displayInfo() on each. 
○ Goal: Understand how inheritance helps in organizing shared and unique 
features across subclasses and use polymorphism for dynamic method calls.  */

// Superclass
class Vehicle {
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Car subclass
class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Truck subclass
class Truck extends Vehicle {
    double loadCapacity; // in tons

    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Motorcycle subclass
class Motorcycle extends Vehicle {
    boolean hasGear;

    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        super(maxSpeed, fuelType);
        this.hasGear = hasGear;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Gear: " + hasGear);
    }
}

// Main class
public class VehicleandTransport {
    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10);
        vehicles[2] = new Motorcycle(160, "Petrol", true);

        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}
