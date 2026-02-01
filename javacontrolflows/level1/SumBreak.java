/*Rewrite the program 10 to find the sum until the user enters 0 or a negative number using while loop and break statement
Hint => 
Use infinite while loop as in while (true)
Take the user entry and check if the user entered 0 or a negative number to break the loop using break;
 */
import java.util.Scanner;

public class SumBreak {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Variable to store the total sum of entered values
        double total = 0.0;

        // Infinite loop to keep taking input
        while (true) {

            // Reading a value from the user
            double value = sc.nextDouble();

            // If value is zero or negative, exit the loop
            if (value <= 0) {
                break;
            }

            // Adding the value to the total
            total += value;
        }

        // Displaying the final sum
        System.out.println("Total = " + total);

        // Closing the scanner to release resources
        sc.close();
    }
}

