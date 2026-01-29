/* Create a program to convert weight in pounds to kilograms.
Hint => 1 pound = 2.2 kg
I/P => weight
O/P => The weight of the person in pound is ___ and in kg is ___
*/

import java.util.Scanner;

public class Problem12 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double weightPound;
        System.out.print("Enter weight in pounds: ");
        weightPound = input.nextDouble();

        double weightKg = weightPound / 2.2;

        System.out.println(
            "The weight of the person in pound is " + weightPound +
            " and in kg is " + weightKg
        );

        input.close();
    }
}

