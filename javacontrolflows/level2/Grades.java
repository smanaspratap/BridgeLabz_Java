/*Write a program to input marks and 3 subjects physics, chemistry and maths. Compute the percentage and then calculate the grade as per the following guidelines 

Hint => 
Ensure the Output clearly shows the Average Mark as well as the Grade and Remarks
 */

import java.util.Scanner;

public class grades {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Taking Physics marks as input
        System.out.print("Enter Physics marks: ");
        double physics = sc.nextDouble();

        // Taking Chemistry marks as input
        System.out.print("Enter Chemistry marks: ");
        double chemistry = sc.nextDouble();

        // Taking Maths marks as input
        System.out.print("Enter Maths marks: ");
        double maths = sc.nextDouble();

        // Calculating average marks
        double average = (physics + chemistry + maths) / 3;

        // Variables to store grade and remarks
        char grade;
        String remarks;

        // Determining grade and remarks based on average marks
        if (average >= 80) {
            grade = 'A';
            remarks = "Level 4, above agency-normalized standards";
        }
        else if (average >= 70) {
            grade = 'B';
            remarks = "Level 3, at agency-normalized standards";
        }
        else if (average >= 60) {
            grade = 'C';
            remarks = "Level 2, below but approaching standards";
        }
        else if (average >= 50) {
            grade = 'D';
            remarks = "Level 1, well below standards";
        }
        else if (average >= 40) {
            grade = 'E';
            remarks = "Level 1-, too below standards";
        }
        else {
            grade = 'R';
            remarks = "Remedial standards";
        }

        // Displaying the results
        System.out.println("\nAverage Marks: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);

        // Closing the scanner to release resources
        sc.close();
    }
}
