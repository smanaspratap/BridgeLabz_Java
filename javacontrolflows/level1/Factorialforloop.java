/*Rewrite program 14 using for loop
Hint => 
Take the integer input, check for natural number and determine the factorial using for loop 
and finally print the result.*/
import java.util.Scanner;

public class factorialforloop {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the number for which factorial is to be calculated
        int num = sc.nextInt();

        // Checking if the number is positive
        if (num > 0) {

            // Variable to store the factorial result
            int fact = 1;

            // for loop to calculate factorial
            for (int i = 1; i <= num; i++) {

                // Multiply fact by current value of i
                fact *= i;
            }

            // Displaying the factorial result
            System.out.println("Factorial = " + fact);
        }

        // Closing the scanner to free resources
        sc.close();
    }
}
