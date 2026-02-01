/*Create a program to find the factors of a number taken as user input, store the factors in an array, and display the factors
Hint => 
Take the input for a number
Find the factors of the number and save them in an array. For this create integer variable maxFactor and initialize to 10, factors array of size maxFactor and index variable to reflect the index of the array. 
To find factors loop through the numbers from 1 to the number, find the factors, and add them to the array element by incrementing the index. If the index is equal to maxIndex, then need factors array to store more elements
To store more elements, reset the maxIndex to twice its size, use the temp array to store the elements from the factors array, and eventually assign the factors array to the temp array
Finally, Display the factors of the number
 */


import java.util.*;

class factorsofno {

    public static void main(String[] args) {

        // Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Asking the user to enter a number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Initial size of the array to store factors
        int maxSize = 10;

        // Array to store the factors of the number
        int[] factors = new int[maxSize];

        // Index to keep track of how many factors are stored
        int index = 0;

        // Loop from 1 to the given number
        for (int i = 1; i <= number; i++) {

            // Check if 'i' is a factor of the number
            if (number % i == 0) {

                // If array is full, increase its size
                if (index == maxSize) {

                    // Double the size of the array
                    maxSize *= 2;

                    // Create a new temporary array with larger size
                    int[] temp = new int[maxSize];

                    // Copy existing factors into the new array
                    for (int j = 0; j < index; j++) {
                        temp[j] = factors[j];
                    }

                    // Assign the new array back to factors
                    factors = temp;
                }

                // Store the factor and move to the next index
                factors[index++] = i;
            }
        }

        // Displaying all the factors
        System.out.println("Factors are:");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        // Closing the scanner to free resources
        sc.close();
    }
}
