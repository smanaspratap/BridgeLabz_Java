/*Problem 3: Vehicle Registration
Create a Vehicle class to manage the details of vehicles:
Instance Variables: ownerName, vehicleType.
Class Variable: registrationFee (fixed for all vehicles).
Methods:
An instance method displayVehicleDetails() to display owner and vehicle details.
A class method updateRegistrationFee() to change the registration fee.
 */

class Vehicle {
    String ownerName;
    String vehicleType;

    static double registrationFee = 5000;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    // Class method
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Manas", "Car");
        Vehicle v2 = new Vehicle("Rahul", "Bike");

        v1.displayVehicleDetails();
        System.out.println();

        Vehicle.updateRegistrationFee(6500);

        v2.displayVehicleDetails();
    }
}

