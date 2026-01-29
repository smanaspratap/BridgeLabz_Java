/*Program to Handle Mobile Phone Details
Problem Statement: Create a MobilePhone class with attributes brand, model, and price. Add a method to display all the details 
of the phone. The MobilePhone class uses attributes to store the phone's characteristics. The method is used to retrieve and 
display this information for each object.
 */

import java.util.Scanner;

class MobilePhone {
    String brand;
    String model;
    int price;

    // Constructor
    MobilePhone(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display phone details
    public void displayDetails() {
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
    }
}

public class Mobilephone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Mobile Brand:");
        String brand = sc.next();

        System.out.println("Enter Mobile Model:");
        String model = sc.next();

        System.out.println("Enter Mobile Price:");
        int price = sc.nextInt();

        MobilePhone phone = new MobilePhone(brand, model, price);

        System.out.println("\n--- Mobile Phone Details ---");
        phone.displayDetails();

        sc.close();
    }
}
