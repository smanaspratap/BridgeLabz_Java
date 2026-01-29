/*
Sample Program 6: Vehicle Registration System
Uses static, this, final, and instanceof.
*/

class Vehicle {

    // Static variable
    static double registrationFee = 5000;

    // Final variable
    final String registrationNumber;

    // Instance variables
    String ownerName;
    String vehicleType;

    // Constructor using this
    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Static method
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    void displayVehicleDetails() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle("JH01AB1234", "Manas", "Car");

        if (v instanceof Vehicle) {
            v.displayVehicleDetails();
        }
    }
}
