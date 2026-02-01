/*Write a program to input the Principal, Rate, and Time values and calculate Simple Interest.
Hint => 
Simple Interest = Principal * Rate * Time / 100
Take user input for principal, rate, time
Write a method to calculate the simple interest given principle, rate and time as parameters
Output “The Simple Interest is ___ for Principal ___, Rate of Interest ___ and Time ___”
 */
import java.util.*;

public class simpleinterest1 {

    // This static method calculates Simple Interest
    // principle -> principal amount
    // rate      -> rate of interest (in percentage)
    // time      -> time period
    static double simpleinterest(double principle, double rate, double time) {

        // Formula for Simple Interest:
        // (principal * rate * time) / 100
        double simpleinterest = (principle * rate * time) / 100;

        // Return the calculated simple interest
        return simpleinterest;
    }

    public static void main(String[] args) {

        // Create Scanner object to take user input
        Scanner in = new Scanner(System.in);

        // Read principal amount
        double p = in.nextDouble();

        // Read rate of interest
        double r = in.nextDouble();

        // Read time period
        double t = in.nextDouble();

        // Call method to calculate simple interest
        double ans = simpleinterest(p, r, t);

        // Print the result with a descriptive message
        System.out.println(
            "The Simple Interest is " + ans +
            " for principal " + p +
            ", Rate of Interest is " + r + "% and Time " + t + "."
        );

        // Close the Scanner to free resources
        in.close();
    }
}
