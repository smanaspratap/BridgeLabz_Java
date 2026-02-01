/*Create a program to print a multiplication table of a number.
Hint => 
Get an integer input and store it in the number variable. Also, define a integer array to store the results of multiplication from 1 to 1
Run a loop from 1 to 10 and store the results in the multiplication table array
Finally, display the result from the array in the format number * i = ___
 */

import java.util.*;

class multiplicationtable {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Prompting the user to enter a number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Array to store the multiplication table (1 to 10)
        int[] table = new int[10]; // initialization

        // Loop to calculate the multiplication table
        for (int i = 1; i <= 10; i++) {

            // Storing the result of multiplication in the array
            table[i - 1] = number * i; // table operation
        }

        // Loop to print the multiplication table
        for (int i = 1; i <= 10; i++) {

            // Displaying each line of the table
            System.out.println(number + " * " + i + " = " + table[i - 1]); // print
        }

        // Closing the scanner to release resources
        sc.close();
    }
}
