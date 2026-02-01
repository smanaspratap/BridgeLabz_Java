/*Write a program to take user input for the age of all 10 students in a class and check 
whether the student can vote depending on his/her age is greater or equal to 18.
Hint => 
Define an array of 10 integer elements and take user input for the student's age. 
Loop through the array using the length property and for the element of the array check If the age is a negative number print an invalid age and if 18 or above, print The student with the age ___ can vote. Otherwise, print The student with the age ___ cannot vote. 
*/
import java.util.*;

class voting {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner in = new Scanner(System.in);

        // Array to store ages of 10 students
        int[] arr = new int[10];

        // Loop to take age input for each student
        for (int i = 0; i < 10; i++) {

            // Prompting the user to enter age
            System.out.println("Enter your age:");
            arr[i] = in.nextInt();
        }

        // Loop to check voting eligibility for each age
        for (int age : arr) {

            // Checking for invalid age
            if (age < 0) {
                System.out.println("Invalid Age");
            }
            // Checking if the person is eligible to vote
            else if (age >= 18) {
                System.out.println("The student with age " + age + " can vote");
            }
            // If age is less than 18
            else {
                System.out.println("The student with age " + age + " cannot vote");
            }
        }

        // Closing the scanner to free system resources
        in.close();
    }
}
