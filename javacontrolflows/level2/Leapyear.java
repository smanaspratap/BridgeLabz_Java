/*Write a LeapYear program that takes a year as input and outputs the Year is a Leap Year or not a Leap Year. 
Hint => 
The LeapYear program only works for year >= 1582, corresponding to a year in the Gregorian calendar. So ensure to check for the same. 
Further, the Leap Year is a Year divisible by 4 and not 100 unless it is divisible by 400. E.g. 1800 is not a Leap Year and 2000 is a Leap Year.
Write code having multiple if else statements based on conditions provided above and a second part having only one if statement and multiple logical 
 */

import java.util.Scanner;

public class Leapyr {

    public static void main(String[] args) {

        // Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Prompting the user to enter a year
        System.out.print("Enter the year: ");
        int year = sc.nextInt();

        // Checking if the year is valid according to the Gregorian calendar
        if (year < 1582) {

            // Gregorian calendar started from the year 1582
            System.out.println("Year must be 1582 or later (Gregorian Calendar).");
        }
        // If the year is divisible by 400, it is a leap year
        else if (year % 400 == 0) {
            System.out.println("Year is a Leap Year");
        }
        // If the year is divisible by 100 but not by 400, it is NOT a leap year
        else if (year % 100 == 0) {
            System.out.println("Year is not a Leap Year");
        }
        // If the year is divisible by 4, it is a leap year
        else if (year % 4 == 0) {
            System.out.println("Year is a Leap Year");
        }
        // All other years are not leap years
        else {
            System.out.println("Year is not a Leap Year");
        }

        // Closing the scanner to release resources
        sc.close();
    }
}
