// Write a program to check for the natural number and write the sum of n natural numbers 
// Hint => 
// A Natural Number is a positive integer (1,2,3, etc) sometimes with the inclusion of 0
// A sum of n natural numbers is n * (n+1) / 2 
// I/P => number
// O/P => If the number is a positive integer then the output is
// The sum of ___ natural numbers is ___
// Otherwise 
// The number ___ is not a natural number


import java.util.Scanner;

public class Natnos {

    public static void main(String[] args) {

        // Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the number from the user
        int number = sc.nextInt();

        // Checking if the number is a natural number (0 or positive)
        if (number >= 0) {

            // Formula to calculate sum of first n natural numbers
            // sum = n * (n + 1) / 2
            int sum = number * (number + 1) / 2;

            // Displaying the result
            System.out.println("The sum of " + number + " natural numbers is " + sum);
        }
        // If the number is negative
        else {
            System.out.println("The number " + number + " is not a natural number");
        }

        // Closing the scanner to free resources
        sc.close();
    }
}
