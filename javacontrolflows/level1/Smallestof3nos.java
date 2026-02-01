// Write a program to check if the first is the smallest of the 3 numbers.
// I/P => number1, number2, number3
// O/P => Is the first number the smallest? ____
import java.util.Scanner;

public class smallestof3nos {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Taking the first number as input
        System.out.print("Enter number1: ");
        int number1 = sc.nextInt();

        // Taking the second number as input
        System.out.print("Enter number2: ");
        int number2 = sc.nextInt();

        // Taking the third number as input
        System.out.print("Enter number3: ");
        int number3 = sc.nextInt();

        // Checking if the first number is the smallest among the three
        boolean isSmallest = (number1 < number2) && (number1 < number3);

        // Displaying the result
        System.out.println("Is the first number the smallest? " + isSmallest);

        // Closing the scanner to release resources
        sc.close();
    }
}
