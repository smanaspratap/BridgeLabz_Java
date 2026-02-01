/*Create a program to check if a number is Armstrong or not. Use the hints to show the steps clearly in the code
Hint => 
Armstrong Number is a number whose Sum of cubes of each digit results in the original number e.g. 153 = 1^3 + 5^3 + 3^3
Get an integer input and store it in the number variable define sum variable, initialize it to zero and originalNumber variable, and assign it to the input number variable
Use the while loop till the originalNumber is not equal to zero
In the while loop find the reminder number by using the modulus operator as in  number % 10. Find the cube of the number and add it to the sum variable
Again in while loop find the quotient of the number and assign it to the original number using number / 10 expression. This romoves the last digit of the original number.
Finally check if the number and the sum are the same, if same its an Armstrong number else not. So display accordingly
 */


import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the number to be checked
        int number = sc.nextInt();

        // Storing the original number for comparison later
        int originalNumber = number;

        // Variable to store the sum of cubes of digits
        int sum = 0;

        // Loop to extract each digit of the number
        while (originalNumber != 0) {

            // Getting the last digit of the number
            int remainder = originalNumber % 10;

            // Adding the cube of the digit to the sum
            sum = sum + (remainder * remainder * remainder);

            // Removing the last digit from the number
            originalNumber = originalNumber / 10;
        }

        // Checking if the number is an Armstrong number
        if (sum == number) {
            System.out.println("Armstrong Number");
        }
        else {
            System.out.println("Not an Armstrong Number");
        }

        // Closing the scanner to release resources
        sc.close();
    }
}

