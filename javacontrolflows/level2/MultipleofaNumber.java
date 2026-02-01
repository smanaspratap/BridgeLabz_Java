/*Create a program to find all the multiple of a number taken as user input below 100.
Hint => 
Get input value for a variable named number.
Run a for loop backward: from i = 100 to i = 1.
Inside the loop, check if i perfectly divide the number.
If true, print the number and continue the loop.
 */

import java.util.Scanner;

class multipleofno {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Taking a number as input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Displaying header message
        System.out.println("Multiples of " + number + " below 100:");

        // Loop backward from 100 to 1
        for (int i = 100; i >= 1; i--) {

            // Checking if the current number is a multiple of the given number
            if (i % number == 0) {
                System.out.println(i);
            }
        }

        // Closing the scanner to release resources
        sc.close();
    }
}

