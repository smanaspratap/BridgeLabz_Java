/*Write a Program to check if the given number is a prime number or not
Hint => 
A number that can be divided exactly only by itself and 1 are Prime Numbers,
Prime Numbers checks are done for numbers greater than 1
Loop through all the numbers from 2 to the user input number and check if the reminder is zero. If the reminder is zero break out from the loop as the number is divisible by some other number and is not a prime number. 
Use isPrime boolean variable to store the result
 */
import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Prompting the user to enter a number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Flag variable to track whether the number is prime
        boolean isPrime = true;

        // Prime numbers must be greater than 1
        if (number <= 1) {
            isPrime = false;
        } 
        else {
            // Loop to check divisibility from 2 to number-1
            for (int i = 2; i < number; i++) {

                // If number is divisible by any value, it is not prime
                if (number % i == 0) {
                    isPrime = false;
                    break; // Exit loop as factor is found
                }
            }
        }

        // Printing the result
        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } 
        else {
            System.out.println(number + " is not a Prime Number");
        }

        // Closing the scanner to release resources
        sc.close();
    }
}
