/*Write a program to take user input for the age of all 10 students in a class and check 
whether the student can vote depending on his/her age is greater or equal to 18.
Hint => 
Define an array of 10 integer elements and take user input for the student's age. 
Loop through the array using the length property and for the element of the array check If the age is a negative number print an invalid age and if 18 or above, print The student with the age ___ can vote. Otherwise, print The student with the age ___ cannot vote. 
*/
import java.util.*;
public class voting{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[10];

        for(int i = 0 ; i<10; i++){
            System.out.println("enter your age ");
            arr[i] = in.nextInt();
            
        }
        for(int age: arr ){
            if(age<0){
                System.out.println("Invalid Age");
            }else if(age >= 18){
                System.out.println("The student with age "+age+ " can vote");
            }else{
                System.out.println("The student with age " + age + " cannot vote");
            }
        }
        in.close();
    }
}