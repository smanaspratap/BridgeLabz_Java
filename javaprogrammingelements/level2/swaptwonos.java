/*Create a program to swap two numbers 
Hint => 
Create a variable number1 and take user input.
Create a variable number2 and take user input.
Swap number1 and number2  and print the swapped output
I/P => number1, number2
O/P => The swapped numbers are  ___ and ___ */


import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number1;
        int number2;

        System.out.print("Enter first number: ");
        number1 = input.nextInt();

        System.out.print("Enter second number: ");
        number2 = input.nextInt();

        int temp = number1;
        number1 = number2;
        number2 = temp;

        System.out.println(
            "The swapped numbers are " + number1 + " and " + number2
        );

        input.close();
    }
}
