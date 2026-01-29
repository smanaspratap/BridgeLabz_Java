/*Rewrite program 1 to determine Leap Year with single if condition using logical and && and or || operators
 */


import java.util.Scanner;

public class Leapyr2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the year to check if it's a Leap year or not:");
        int n = sc.nextInt();

        if (n % 400 == 0 || (n % 4 == 0 && n % 100 != 0)) {
            System.out.println("Leap year baby!");
        } else {
            System.out.println("Not a leap year");
        }

        sc.close();
    }
}
