/*Write a program to store multiple values in an array up to a maximum of 10 or until the user enters a 0 or a negative number. 
Show all the numbers as well as the sum of all numbers 
Hint => 
Create a variable to store an array of 10 elements of type double as well as a variable to store the total of type double initializes to 0.0. Also, the index variable is initialized to 0 for the array
Use infinite while loop as in while (true)
Take the user entry and check if the user entered 0 or a negative number to break the loop 
Also, break from the loop if the index has a value of 10 as the array size is limited to 10.
If the user entered a number other than 0 or a negative number inside the while loop then assign the number to the array element and increment the index value
Take another for loop to get the values of each element and add it to the total 
Finally display the total value
 */


import java.util.*;

class multiplevaluesinarray {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner in = new Scanner(System.in);

        // Array to store up to 10 double values
        double[] arr = new double[10];

        // Variable to store the sum of entered numbers
        double total = 0.0;

        // Index to track how many numbers have been stored
        int index = 0;

        // Loop to keep taking input until condition breaks
        while (true) {

            // Prompting the user to enter a number
            System.out.print("Enter a number: ");
            double num = in.nextDouble();

            // Stop input if number is zero/negative
            // or if the array is already full
            if (num <= 0 || index == 10) {
                break;
            }

            // Store the number in the array
            arr[index] = num;
            index++;
        }

        // Displaying the numbers entered by the user
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {

            System.out.println(arr[i]);

            // Adding each number to total
            total += arr[i];
        }

        // Displaying the sum of all entered numbers
        System.out.println("\nSum of all numbers = " + total);

        // Closing the scanner to free resources
        in.close();
    }
}
