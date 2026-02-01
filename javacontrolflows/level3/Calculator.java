/*Write a program to create a calculator using switch...case.
Hint => 
Create two double variables named first and second and a String variable named op.
Get input values for all variables.
The input for the operator can only be one of the four values: "+", "-", "*" or "/".
Run a for loop from i = 1 to i < number.
Based on the input value of the op, perform specific operations using the switch...case statement and print the result.
If op is +, perform addition between first and second; if it is -, perform subtraction and so on.
If op is neither of those 4 values, print Invalid Operator.
 */

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the first number
        double first = sc.nextDouble();

        // Reading the second number
        double second = sc.nextDouble();

        // Reading the operator (+, -, *, /)
        String op = sc.next();

        // Performing calculation based on the operator
        switch (op) {

            case "+":
                // Addition
                System.out.println(first + second);
                break;

            case "-":
                // Subtraction
                System.out.println(first - second);
                break;

            case "*":
                // Multiplication
                System.out.println(first * second);
                break;

            case "/":
                // Division
                System.out.println(first / second);
                break;

            // If operator is not valid
            default:
                System.out.println("Invalid Operator");
        }

        // Closing the scanner to release resources
        sc.close();
    }
}

