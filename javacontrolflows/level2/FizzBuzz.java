/*Write a program FizzBuzz, take a number as user input, and if it is a positive integer loop from 0 to the number and print the number, but for multiples of 3 print "Fizz" instead of the number, for multiples of 5 print "Buzz", and for multiples of both print "FizzBuzz".
Hint => 
Write the program and use for loop
 */

import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Prompting the user to enter a number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Checking if the number is positive
        if (number > 0) {

            // Loop from 0 to the given number
            for (int i = 0; i <= number; i++) {

                // If number is divisible by both 3 and 5
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
                // If number is divisible by 3
                else if (i % 3 == 0) {
                    System.out.println("Fizz");
                }
                // If number is divisible by 5
                else if (i % 5 == 0) {
                    System.out.println("Buzz");
                }
                // If number is divisible by neither 3 nor 5
                else {
                    System.out.println(i);
                }
            }
        }
        // If the entered number is not positive
        else {
            System.out.println("Please enter a positive integer");
        }

        // Closing the scanner to release resources
        sc.close();
    }
}

