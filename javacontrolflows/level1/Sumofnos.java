/*Write a program to find the sum of numbers until the user enters 0
Hint => 
Create a variable total of type double initialize to 0.0. Also, create a variable to store the double value the user enters
Use the while loop to check if the user entered is 0
If the user entered value is not 0 then inside the while block add user entered value to the total and ask the user to input again
The loop will continue till the user enters zero and outside the loop display the total value
 */

import java.util.Scanner;

public class sumofnos {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Variable to store the total sum of entered numbers
        double total = 0.0;

        // Variable to store each input value
        double value;

        // Loop continues until the user enters 0
        while ((value = sc.nextDouble()) != 0) {

            // Adding the entered value to the total
            total += value;
        }

        // Displaying the final sum
        System.out.println("Total = " + total);

        // Closing the scanner to release resources
        sc.close();
    }
}
