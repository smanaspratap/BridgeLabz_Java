/*Create a program to find the mean height of players present in a football team.
Hint => 
The formula to calculate the mean is: mean = sum of all elements / number of elements
Create a double array named heights of size 11 and get input values from the user.
Find the sum of all the elements present in the array.
Divide the sum by 11 to find the mean height and print the mean height of the football team
 */

import java.util.*;

class meanht {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Array to store the heights of 11 players
        double[] heights = new double[11];

        // Variable to store the sum of all heights
        double sum = 0;

        // Loop to take height input for each player
        for (int i = 0; i < heights.length; i++) {

            // Prompting the user to enter the height of each player
            System.out.print("Enter height of player " + (i + 1) + ": ");

            // Storing the height in the array
            heights[i] = sc.nextDouble();

            // Adding the height to the sum
            sum += heights[i];
        }

        // Calculating the mean height
        double mean = sum / 11;

        // Displaying the mean height of the team
        System.out.println("Mean height of the team = " + mean);

        // Closing the scanner to free resources
        sc.close();
    }
}
