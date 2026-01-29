/*Write a program that takes a year as input and outputs the Year is a Leap Year or not 
Hint => 
The LeapYear program only works for year >= 1582, corresponding to a year in the Gregorian calendar. 
Also Leap year is divisible by 4 and not divisible by 100 or divisible by 400
Write a method to check for Leap Year using the conditions a and b
 */
import java.util.*;
public class leapyr {
    static boolean isLeap(int y) {
        if (y < 1582) return false;
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        System.out.println(isLeap(y));
        sc.close();
    }
}
