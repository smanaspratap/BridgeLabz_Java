/*Create a program to find the BMI of a person
Hint => 
Take user input in double for the weight (in kg) of the person and height (in cm) for the person and store it in the corresponding variable.
Use the formula BMI = weight / (height * height). Note unit is kg/m^2. For this convert cm to meter
Use the table to determine the weight status of the person
 */

import java.util.Scanner;

public class BMI {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Asking the user to enter weight in kilograms
        System.out.print("Enter weight (in kg): ");
        double weight = sc.nextDouble();

        // Asking the user to enter height in centimeters
        System.out.print("Enter height (in cm): ");
        double heightCm = sc.nextDouble();

        // Converting height from centimeters to meters
        double heightMeter = heightCm / 100;

        // Calculating BMI using the formula:
        // BMI = weight / (height in meters * height in meters)
        double bmi = weight / (heightMeter * heightMeter);

        // Variable to store BMI category
        String status;

        // Determining weight status based on BMI value
        if (bmi < 18.5) {
            status = "Underweight";
        }
        else if (bmi < 25) {
            status = "Normal weight";
        }
        else if (bmi < 30) {
            status = "Overweight";
        }
        else {
            status = "Obese";
        }

        // Displaying BMI value and weight status
        System.out.println("\nBMI = " + bmi);
        System.out.println("Weight Status: " + status);

        // Closing the scanner to release resources
        sc.close();
    }
}

