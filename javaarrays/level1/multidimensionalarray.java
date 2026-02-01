/*Working with Multi-Dimensional Arrays. Write a Java program to create a 2D Array and Copy the 2D Array into a single dimension array
Hint => 
Take user input for rows and columns, create a 2D array (Matrix), and take the user input 
Copy the elements of the matrix to a 1D array. For this create a 1D array of size rows*columns as in int[] array = new int[rows * columns];
Define the index variable and Loop through the 2D array. Copy every element of the 2D array into the 1D array and increment the index
Note: For looping through the 2D array, you will need Nested for loop, Outer for loop for rows, and the inner for loops to access each element
 */


import java.util.*;

class multidimensionalarray {

    public static void main(String[] args) {

        // Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Taking number of rows from the user
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        // Taking number of columns from the user
        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        // Declaring a 2D array (matrix) with given rows and columns
        int[][] matrix = new int[rows][cols];

        // Taking input for each element of the 2D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Prompting user for each matrix element
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        // Creating a 1D array to store elements of the 2D array
        int[] array = new int[rows * cols];

        // Index to track position in the 1D array
        int index = 0;

        // Converting the 2D array into a 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Storing each element into the 1D array
                array[index++] = matrix[i][j];
            }
        }

        // Displaying the elements of the 1D array
        System.out.println("1D Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        // Closing the scanner to release system resources
        sc.close();
    }
}
