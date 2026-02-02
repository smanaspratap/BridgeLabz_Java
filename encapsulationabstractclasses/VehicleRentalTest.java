/*
Description: Design a system to manage vehicle rentals:
Define an abstract class Vehicle with fields like vehicleNumber, type, and rentalRate.
Add an abstract method calculateRentalCost(int days).
Create subclasses Car, Bike, and Truck with specific implementations of calculateRentalCost().
Use an interface Insurable with methods calculateInsurance() and getInsuranceDetails().
Apply encapsulation to restrict access to sensitive details like insurance policy numbers.
Demonstrate polymorphism by iterating over a list of vehicles and calculating rental and insurance costs for each.
*/

import java.util.ArrayList;
import java.util.List;

/* ---------- Interface ---------- */
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

/* ---------- Abstract Class ---------- */
abstract class Vehicle {

    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    // sensitive data (encapsulated)
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Encapsulation (setter only for sensitive data)
    public void setInsurancePolicyNumber(String policyNumber) {
        this.insurancePolicyNumber = policyNumber;
    }

    public String getType() {
        return type;
    }
}

/* ---------- Car ---------- */
class Car extends Vehicle implements Insurable {

    public Car(String number, double rate) {
        super(number, "Car", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: ₹500";
    }
}

/* ---------- Bike ---------- */
class Bike extends Vehicle implements Insurable {

    public Bike(String number, double rate) {
        super(number, "Bike", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 200;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: ₹200";
    }
}

/* ---------- Truck ---------- */
class Truck extends Vehicle implements Insurable {

    public Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days * 1.5; // extra heavy-duty charge
    }

    @Override
    public double calculateInsurance() {
        return 1000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: ₹1000";
    }
}

/* ---------- Main Class ---------- */
public class VehicleRentalTest {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("MH12AB1234", 1500));
        vehicles.add(new Bike("MH12XY5678", 500));
        vehicles.add(new Truck("MH12TR9999", 3000));

        int days = 3;

        // Polymorphism in action
        for (Vehicle v : vehicles) {

            double rentalCost = v.calculateRentalCost(days);
            double insurance = 0;

            if (v instanceof Insurable) {
                insurance = ((Insurable) v).calculateInsurance();
            }

            System.out.println(v.getType() + " Rental Cost: ₹" + rentalCost);
            System.out.println("Insurance Cost: ₹" + insurance);
            System.out.println("--------------------------");
        }
    }
}
