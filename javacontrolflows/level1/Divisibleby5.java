// Write a program to check if a number is divisible by 5
// I/P => number
// O/P => Is the number ___ divisible by 5? ___


import java.util.Scanner;

public class Divisibleby5 {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner inp = new Scanner(System.in);

        // Reading the number from the user
        int n = inp.nextInt();

        // Checking if the number is divisible by 5
        if (n % 5 == 0) {

            // If remainder is 0, the number is divisible by 5
            System.out.println("Number is Div by 5");
        }
        // If remainder is not 0
        else {
            System.out.println("Not Div");
        }

        // Closing the scanner to release resources
        inp.close();
    }
}
