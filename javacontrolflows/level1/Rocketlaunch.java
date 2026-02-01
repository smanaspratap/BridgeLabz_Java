/*Write a program to count down the number from the user input value to 1 using a while loop for a rocket launch
Hint => 
Create a variable counter to take user inputted value for the countdown.
Use the while loop to check if the counter is 1
Inside a while loop, print the value of the counter and decrement the counter.
 */
import java.util.Scanner;

public class rocketlaunch {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the starting number for the countdown
        int counter = sc.nextInt();

        // while loop to perform countdown until counter reaches 1
        while (counter >= 1) {

            // Printing the current countdown number
            System.out.println(counter);

            // Decrementing the counter
            counter--;
        }

        // Closing the scanner to release resources
        sc.close();
    }
}
