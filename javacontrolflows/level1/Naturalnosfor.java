/*Rewrite the program number 12 with the for loop instead of a while loop to find the sum of n Natural Numbers. 
Hint => 
Take the user input number and check whether it's a Natural number
If it's a natural number Compute using formulae as well as compute using for loop
Compare the two results and print the result
 */


import java.util.Scanner;

public class naturalnosfor {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the value of n (number of natural numbers)
        int n = sc.nextInt();

        // Checking if the number is valid (0 or positive)
        if (n >= 0) {

            // Variable to store sum calculated using for loop
            int sum = 0;

            // for loop to calculate sum of natural numbers
            for (int i = 1; i <= n; i++) {

                // Adding current value of i to sum
                sum += i;
            }

            // Calculating sum using the mathematical formula
            // formulaSum = n * (n + 1) / 2
            int formulaSum = n * (n + 1) / 2;

            // Displaying both results
            System.out.println("For Loop Sum: " + sum);
            System.out.println("Formula Sum: " + formulaSum);
        }

        // Closing the scanner to release resources
        sc.close();
    }
}

