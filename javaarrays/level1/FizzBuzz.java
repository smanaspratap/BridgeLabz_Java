/*Write a program FizzBuzz, take a number as user input and if it is a positive integer loop from 0 to the number and save the number, but for multiples of 3 save "Fizz" instead of the number, for multiples of 5 save "Buzz", and for multiples of both save "FizzBuzz". Finally, print the array results for each index position in the format Position 1 = 1, …, Position 3 = Fizz,...
Hint => 
Create a String Array to save the results and 
Finally, loop again to show the results of the array based on the index position
 */

import java.util.*;

public class FizzBuzz {

    public static void main(String[] args) {

        // Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Prompting the user to enter a positive number
        System.out.print("Enter a positive number: ");
        int number = sc.nextInt();

        // Checking for invalid (non-positive) input
        if (number <= 0) {
            System.out.println("Invalid input");
        }

        // Array to store the FizzBuzz results
        // Size is number + 1 so index matches the number directly
        String[] result = new String[number + 1];

        // Loop from 1 to the given number
        for (int i = 1; i <= number; i++) {

            // If number is divisible by both 3 and 5
            if (i % 3 == 0 && i % 5 == 0) {
                result[i] = "FizzBuzz";
            }
            // If number is divisible by 3
            else if (i % 3 == 0) {
                result[i] = "Fizz";
            }
            // If number is divisible by 5
            else if (i % 5 == 0) {
                result[i] = "Buzz";
            }
            // If number is divisible by neither 3 nor 5
            else {
                result[i] = String.valueOf(i);
            }
        }

        // Printing the stored FizzBuzz results
        for (int i = 1; i <= number; i++) {
            System.out.println("Position " + i + " = " + result[i]);
        }

        // Closing the scanner to release resources
        sc.close();
    }
}
