// Write a program to check if the first, second, or third number is the largest of the three.
// I/P => number1, number2, number3
// O/P => 
// Is the first number the largest? ____
// Is the second number the largest? ___
// Is the third number the largest? ___



import java.util.Scanner;

public class Largestnos {

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

        // Checking if the first number is the largest
        boolean isFirstLargest = (number1 > number2) && (number1 > number3);

        // Checking if the second number is the largest
        boolean isSecondLargest = (number2 > number1) && (number2 > number3);

        // Checking if the third number is the largest
        boolean isThirdLargest = (number3 > number1) && (number3 > number2);

        // Displaying the results
        System.out.println("Is the first number the largest? " + isFirstLargest);
        System.out.println("Is the second number the largest? " + isSecondLargest);
        System.out.println("Is the third number the largest? " + isThirdLargest);

        // Closing the scanner to release resources
        sc.close();
    }
}
