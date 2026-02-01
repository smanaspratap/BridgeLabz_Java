// Write a program to check whether a person can vote, depending on whether his/her age is greater than or equal to 18.
// Hint => 
// Get integer input from the user and store it in the age variable.
// If the person is 18 or older, print "The person can vote." Otherwise, print "The person cannot vote." 
// I/P => age
// O/P => If the person's age is greater or equal to 18 then the output is 
// The person's age is ___ and can vote.
// Otherwise 
// The person's age is ___ and cannot vote.

import java.util.Scanner;

public class vote {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the age of the person
        int age = sc.nextInt();

        // Checking if the person is eligible to vote
        if (age >= 18) {

            // If age is 18 or more, the person can vote
            System.out.println("The person's age is " + age + " and can vote.");
        }
        // If age is less than 18
        else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }

        // Closing the scanner to release resources
        sc.close();
    }
}
