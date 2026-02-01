/*Create a program to find the maximum number of handshakes among N number of students.
Hint => 
Get integer input for number of students
Use the combination = (n * (n - 1)) / 2 formula to calculate the maximum number of possible handshakes.
Write a method to use the combination formulae to calculate the number of handshakes
 */
import java.util.Scanner;

public class maxnoofhandshakes {

    // This static method calculates the maximum number of handshakes
    // possible among n people
    static int maxHandshakes(int n) {

        // Formula for maximum handshakes:
        // n * (n - 1) / 2
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {

        // Create a Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Read the number of people
        int n = sc.nextInt();

        // Call the method to calculate maximum handshakes
        int result = maxHandshakes(n);

        // Print the result
        System.out.println(result);

        // Close the Scanner to free system resources
        sc.close();
    }
}
