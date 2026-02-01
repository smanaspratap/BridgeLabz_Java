/*Create a program to find the multiplication table of a number entered by the user from 6 to 9.
Hint => 
Take integer input and store it in the variable number
Using a for loop, find the multiplication table of number from 6 to 9 and print it in the format number * i = ___ 
*/

import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the number for which the multiplication table is needed
        int number = sc.nextInt();

        // Loop to print the multiplication table from 6 to 9
        for (int i = 6; i <= 9; i++) {

            // Printing the multiplication result for each value of i
            System.out.println(number + " * " + i + " = " + (number * i));
        }

        // Closing the scanner to release resources
        sc.close();
    }
}
