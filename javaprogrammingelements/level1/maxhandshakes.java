/* Create a program to find the maximum number of handshakes among N number of students.
Hint => 
Get integer input for numberOfStudents variable.
Use the combination = (n * (n - 1)) / 2 formula to calculate the maximum number of possible handshakes.
Display the number of possible handshakes.
*/

import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numberOfStudents;
        System.out.print("Enter number of students: ");
        numberOfStudents = input.nextInt();

        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        System.out.println(
            "The maximum number of possible handshakes among " +
            numberOfStudents + " students is " + handshakes
        );

        input.close();
    }
}
