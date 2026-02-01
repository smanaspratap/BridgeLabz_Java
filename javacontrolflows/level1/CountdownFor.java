/*Rewrite program 8 to do the countdown using the for-loop */


import java.util.Scanner;

public class CountdownFor {

    public static void main(String[] args) {

        // Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the starting number for countdown
        int counter = sc.nextInt();

        // for loop to print numbers from counter down to 1
        for (int i = counter; i >= 1; i--) {

            // Printing the current value of i
            System.out.println(i);
        }

        // Closing the scanner to release resources
        sc.close();
    }
}

