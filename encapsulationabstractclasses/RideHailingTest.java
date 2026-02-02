/*
Description: Develop a ride-hailing application:
Define an abstract class Vehicle with fields like vehicleId, driverName, and ratePerKm.
Add abstract methods calculateFare(double distance) and a concrete method getVehicleDetails().
Create subclasses Car, Bike, and Auto, overriding calculateFare() based on type-specific rates.
Use an interface GPS with methods getCurrentLocation() and updateLocation().
Secure driver and vehicle details using encapsulation.
Demonstrate polymorphism by creating a method to calculate fares
for different vehicle types dynamically.
*/

import java.util.ArrayList;
import java.util.List;

/* ---------- Interface ---------- */
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

/* ---------- Abstract Class ---------- */
abstract class Vehicle {

    private String vehicleId;
    private String driverName;
    protected double ratePerKm;

    // encapsulated GPS data
    private String currentLocation = "Unknown";

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID  : " + vehicleId);
        System.out.println("Driver Name : " + driverName);
    }

    // Encapsulation (GPS helpers)
    protected String getLocation() {
        return currentLocation;
    }

    protected void setLocation(String location) {
        this.currentLocation = location;
    }
}

/* ---------- Car ---------- */
class Car extends Vehicle implements GPS {

    public Car(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 50; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String location) {
        setLocation(location);
    }
}

/* ---------- Bike ---------- */
class Bike extends Vehicle implements GPS {

    public Bike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm; // cheapest
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String location) {
        setLocation(location);
    }
}

/* ---------- Auto ---------- */
class Auto extends Vehicle implements GPS {

    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 20; // small base charge
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String location) {
        setLocation(location);
    }
}

/* ---------- Main Class ---------- */
public class RideHailingTest {

    // Polymorphic fare calculation
    static void calculateFares(List<Vehicle> vehicles, double distance) {

        for (Vehicle v : vehicles) {

            v.getVehicleDetails();
            System.out.println("Distance : " + distance + " km");
            System.out.println("Fare     : ₹" + v.calculateFare(distance));
            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {

        List<Vehicle> rides = new ArrayList<>();

        rides.add(new Car("C101", "Prajwal", 15));
        rides.add(new Bike("B202", "Amit", 8));
        rides.add(new Auto("A303", "Ravi", 12));

        calculateFares(rides, 10);
    }
}
