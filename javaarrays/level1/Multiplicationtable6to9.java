/*Create a program to find the multiplication table of a number entered by the user from 6 to 9 and display the result
Hint => 
Take integer input and store it in the variable number as well as define an integer array to store the multiplication result in the variable multiplicationResult
Using a for loop, find the multiplication table of numbers from 6 to 9 and save the result in the array
Finally, display the result from the array in the format number * i = ___
 */

import java.util.*;

public class Multiplicationtable6to9 {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Prompting the user to enter a number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Array to store multiplication results from 6 to 9
        int[] result = new int[4];

        // Index to track position in the array
        int idx = 0;

        // Loop to calculate multiplication values (6 to 9)
        for (int i = 6; i <= 9; i++) {

            // Store the multiplication result in the array
            result[idx] = number * i;
            idx++;
        }

        // Reset index before printing
        idx = 0;

        // Loop to print the multiplication table from 6 to 9
        for (int i = 6; i <= 9; i++) {

            // Display each multiplication result
            System.out.println(number + " * " + i + " = " + result[idx++]);
        }

        // Closing the scanner to release resources
        sc.close();
    }
}
