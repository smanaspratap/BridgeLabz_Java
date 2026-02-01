// Write a program to check whether a number is positive, negative, or zero.
// Hint => 
// Get integer input from the user and store it in the number variable.
// If the number is positive, print positive.
// If the number is negative, print negative.
// If the number is zero, print zero. 

import java.util.Scanner;

public class NumberCheck {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the number from the user
        int number = sc.nextInt();

        // Checking if the number is positive
        if (number > 0) {
            System.out.println("Positive");
        }
        // Checking if the number is negative
        else if (number < 0) {
            System.out.println("Negative");
        }
        // If the number is zero
        else {
            System.out.println("Zero");
        }

        // Closing the scanner to release resources
        sc.close();
    }
}

