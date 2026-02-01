/*Write a program to check whether a number is positive, negative, or zero.
Hint => Get integer input from the user. Write a Method to return -1 for negative number, 1 for positive number and 0 if number is zero
 */

import java.util.Scanner;

public class checkingnos {

    // This static method checks whether a number is
    // positive, negative, or zero
    static int checkNumber(int n) {

        // If the number is greater than 0, it is positive
        if (n > 0) {
            return 1;

        // If the number is less than 0, it is negative
        } else if (n < 0) {
            return -1;

        // If the number is neither positive nor negative, it is zero
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        // Create Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Read an integer value from the user
        int n = sc.nextInt();

        // Call the method to check the number
        int result = checkNumber(n);

        // Print the result:
        //  1  -> Positive number
        // -1  -> Negative number
        //  0  -> Zero
        System.out.println(result);

        // Close the Scanner to release system resources
        sc.close();
    }
}


