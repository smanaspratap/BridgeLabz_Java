/*Rewrite program 1 to determine Leap Year with single if condition using logical and && and or || operators
 */
import java.util.Scanner;

public class Leapyr2 {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Prompting the user to enter a year
        System.out.println("Enter the year to check if it's a Leap year or not:");
        int n = sc.nextInt();

        // Checking leap year condition using a single logical expression
        // Leap year rules:
        // 1. Divisible by 400 → Leap year
        // 2. Divisible by 4 AND not divisible by 100 → Leap year
        if (n % 400 == 0 || (n % 4 == 0 && n % 100 != 0)) {

            // If leap year condition is satisfied
            System.out.println("Leap year baby!");
        }
        // If none of the leap year conditions are satisfied
        else {
            System.out.println("Not a leap year");
        }

        // Closing the scanner to release resources
        sc.close();
    }
}
