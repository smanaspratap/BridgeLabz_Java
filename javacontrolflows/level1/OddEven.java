/*Create a program to print odd and even numbers between 1 to the number entered by the user.
Hint => 
Get an integer input from the user, assign to a variable number and check for Natural Number
Using a for loop, iterate from 1 to the number
In each iteration of the loop, print the number is odd or even number
 */

import java.util.Scanner;

public class OddEven {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the number up to which odd/even check is required
        int number = sc.nextInt();

        // Checking if the number is valid (natural number)
        if (number >= 1) {

            // Loop from 1 to the given number
            for (int i = 1; i <= number; i++) {

                // Checking if the current number is even
                if (i % 2 == 0) {
                    System.out.println(i + " is Even");
                }
                // If the current number is odd
                else {
                    System.out.println(i + " is Odd");
                }
            }
        }

        // Closing the scanner to free resources
        sc.close();
    }
}
