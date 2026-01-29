/*Write a program to check whether a number is positive, negative, or zero.
Hint => Get integer input from the user. Write a Method to return -1 for negative number, 1 for positive number and 0 if number is zero
 */


import java.util.Scanner;

public class checkingnos {

    static int checkNumber(int n) {
        if (n > 0) {
            return 1;
        } else if (n < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = checkNumber(n);
        System.out.println(result);
        sc.close();
    }

}

