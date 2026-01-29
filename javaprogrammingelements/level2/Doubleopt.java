/* Similarly, write the DoubleOpt program by taking double values and doing the same operations.*/

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double a, b, c;

        System.out.print("Enter value of a: ");
        a = input.nextDouble();

        System.out.print("Enter value of b: ");
        b = input.nextDouble();

        System.out.print("Enter value of c: ");
        c = input.nextDouble();

        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        System.out.println(
            "The results of Double Operations are " +
            result1 + ", " + result2 + ", " + result3 + ", and " + result4
        );

        input.close();
    }
}

