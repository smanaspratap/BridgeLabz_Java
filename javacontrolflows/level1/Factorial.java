/*Write a Program to find the factorial of an integer entered by the user.
Hint => 
For example, the factorial of 4 is 1 * 2 * 3 * 4 which is 24.
Take an integer input from the user and assign it to the variable. Check the user has entered a positive integer.
Using a while loop, compute the factorial.
Print the factorial at the end.
 */
import java.util.Scanner;

public class factorial {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the number for which factorial is to be calculated
        int n = sc.nextInt();

        // Checking if the number is positive
        if (n > 0) {

            // Variable to store the factorial result
            int fact = 1;

            // Counter variable for the loop
            int i = 1;

            // Loop to calculate factorial using while loop
            while (i <= n) {

                // Multiply current value of fact by i
                fact = fact * i;

                // Move to the next number
                i++;
            }

            // Displaying the factorial result
            System.out.println(fact);
        }

        // Closing the scanner to free resources
        sc.close();
    }
}

