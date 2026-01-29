/*Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.
Hint => 
Create a class public class StudentVoteChecker and define a method public boolean canStudentVote(int age) which takes in age as a parameter and returns true or false
Inside the method firstly validate the age for a negative number, if a negative return is false cannot vote. For valid age check for age is 18 or above return true; else return false;
In the main function define an array of 10 integer elements, loop through the array by take user input for the student's age, call canStudentVote() and display the result
 */
import java.util.*;
public class StudentVoteChecker {
    boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentVoteChecker s = new StudentVoteChecker();
        for (int i = 0; i < 10; i++) {
            int age = sc.nextInt();
            System.out.println(s.canStudentVote(age));
        }
        sc.close();
    }
}
