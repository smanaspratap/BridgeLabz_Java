/* Write a program to input the unit price of an item and the quantity to be bought. Then, calculate the total price.
Hint => NA
I/P => unitPrice, quantity
O/P => The total purchase price is INR ___ if the quantity ___ and unit price is INR ___*/


import java.util.Scanner;

public class Problem13 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double unitPrice;
        int quantity;

        System.out.print("Enter unit price: ");
        unitPrice = input.nextDouble();

        System.out.print("Enter quantity: ");
        quantity = input.nextInt();

        double totalPrice = unitPrice * quantity;

        System.out.println(
            "The total purchase price is INR " + totalPrice +
            " if the quantity " + quantity +
            " and unit price is INR " + unitPrice
        );

        input.close();
    }
}
