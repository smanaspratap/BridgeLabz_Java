/*Create a program to divide N number of chocolates among M children.
Hint => 
Get an integer value from user for the numberOfchocolates and numberOfChildren.
Find the number of chocolates each child gets and number of remaining chocolates
Display the results
I/P => numberOfchocolates, numberOfChildren
O/P => The number of chocolates each child gets is ___ and the number of remaining chocolates are ___
 */


import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numberOfChocolates;
        int numberOfChildren;

        System.out.print("Enter number of chocolates: ");
        numberOfChocolates = input.nextInt();

        System.out.print("Enter number of children: ");
        numberOfChildren = input.nextInt();

        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        System.out.println(
            "The number of chocolates each child gets is " + chocolatesPerChild +
            " and the number of remaining chocolates are " + remainingChocolates
        );

        input.close();
    }
}

