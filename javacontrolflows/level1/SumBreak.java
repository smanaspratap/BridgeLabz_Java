/*Rewrite the program 10 to find the sum until the user enters 0 or a negative number using while loop and break statement
Hint => 
Use infinite while loop as in while (true)
Take the user entry and check if the user entered 0 or a negative number to break the loop using break;
 */


import java.util.Scanner;

public class SumBreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;

        while (true) {
            double value = sc.nextDouble();
            if (value <= 0)
                break;
            total += value;
        }
        System.out.println("Total = " + total);
        sc.close();
    }
}
