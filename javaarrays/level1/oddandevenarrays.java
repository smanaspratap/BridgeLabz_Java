/*Create a program to save odd and even numbers into odd and even arrays between 1 
to the number entered by the user. Finally, print the odd and even numbers array
Hint => 
Get an integer input from the user, assign it to a variable number, and check for Natural Number. If not a natural number then print an error and exit the program
Create an integer array for even and odd numbers with size = number / 2 + 1
Create index variables for odd and even numbers and initialize them to zero
Using a for loop, iterate from 1 to the number, and in each iteration of the loop, save the odd or even number into the corresponding array
Finally, print the odd and even numbers array using the odd and even index
 */


import java.util.*;

class oddandevenarrays {

    public static void main(String[] args) {

        // Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Asking the user to enter a natural number
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        // Checking for invalid input (not a natural number)
        if (number <= 0) {
            System.out.println("Invalid input. Not a natural number.");
        }

        // Arrays to store even and odd numbers
        // Size is estimated as half of the given number
        int[] even = new int[number / 2 + 1];
        int[] odd = new int[number / 2 + 1];

        // Counters to track number of even and odd elements stored
        int e = 0, o = 0;

        // Loop from 1 to the given number
        for (int i = 1; i <= number; i++) {

            // If the number is even, store it in even array
            if (i % 2 == 0) {
                even[e++] = i;
            }
            // Otherwise, store it in odd array
            else {
                odd[o++] = i;
            }
        }

        // Printing all odd numbers
        System.out.println("Odd numbers:");
        for (int i = 0; i < o; i++) {
            System.out.print(odd[i] + " ");
        }

        // Printing all even numbers
        System.out.println("\nEven numbers:");
        for (int i = 0; i < e; i++) {
            System.out.print(even[i] + " ");
        }

        // Closing the scanner to free resources
        sc.close();
    }
}
