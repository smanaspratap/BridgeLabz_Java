/*Create a program to find the power of a number.
Hint => 
Get integer input for two variables named number and power.
Create a result variable with an initial value of 1.
Run a for loop from i = 1 to i <= power.
In each iteration of the loop, multiply the result with the number and assign the value to the result.
Finally, print the result
 */


import java.util.Scanner;

public class powerofno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        System.out.print("Enter the power: ");
        int power = sc.nextInt();

        // Result initialization
        int result = 1;

        // Loop to calculate power
        for (int i = 1; i <= power; i++) {
            result = result * number;
        }

        // Output
        System.out.println(number + " raised to the power " + power + " is: " + result);

        sc.close();
    }
}
