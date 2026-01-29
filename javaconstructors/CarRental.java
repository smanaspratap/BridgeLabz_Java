/*Car Rental System: Create a CarRental class with attributes customerName, carModel, and rentalDays. Add constructors to 
initialize the rental details and calculate total cost. */

public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 1500;

    // Default constructor
    CarRental() {
        customerName = "Customer";
        carModel = "Hatchback";
        rentalDays = 1;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    void display() {
        System.out.println(customerName + " rented " + carModel);
        System.out.println("Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental c1 = new CarRental();
        CarRental c2 = new CarRental("Manas", "SUV", 5);

        c1.display();
        System.out.println();
        c2.display();
    }
}
