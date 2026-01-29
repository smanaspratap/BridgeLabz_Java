/*Write a program to take user input for 5 numbers and check whether a number is positive or negative. Further for positive numbers check if the number is even or odd. Finally compare the first and last elements of the array and display if they are equal, greater, or less
Hint => 
Write a Method to Check whether the number is positive or negative
Write a Method to check whether the number is even or odd
Write a Method to compare two numbers and return 1 if number1 > number2 or 0 if both are equal or -1 if number1 < number2 
In the main program, Loop through the array using the length call the method isPositive() and if positive call method isEven() and print accordingly 
If the number is negative, print negative. 
Finally compare the first and last element of the array by calling the method compare() and display if they are equal, greater, or less
 */
import java.util.*;
public class checknumbers {
    static boolean isPositive(int n) { return n >= 0; }
    static boolean isEven(int n) { return n % 2 == 0; }
    static int compare(int a, int b) {
        if (a > b) return 1;
        if (a == b) return 0;
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            a[i] = sc.nextInt();
            if (isPositive(a[i])) System.out.println(isEven(a[i]) ? "Even" : "Odd");
            else System.out.println("Negative");
        }
        System.out.println(compare(a[0], a[4]));
        sc.close();
    }
}
