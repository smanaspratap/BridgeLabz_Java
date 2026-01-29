/*Write a program that takes your height in centimeters and converts it into feet and inches
Hint => 1 foot = 12 inches and 1 inch = 2.54 cm
I/P => height
O/P => Your Height in cm is ___ while in feet is ___ and inches is ___
 */


import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double heightCm;
        System.out.print("Enter your height in centimeters: ");
        heightCm = input.nextDouble();

        double totalInches = heightCm / 2.54;
        int feet = (int) totalInches / 12;
        double inches = totalInches % 12;

        System.out.println(
            "Your Height in cm is " + heightCm +
            " while in feet is " + feet +
            " and inches is " + inches
        );

        input.close();
    }
}

