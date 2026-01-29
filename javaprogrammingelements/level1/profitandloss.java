/*Create a program to calculate the profit and loss in number and percentage based on the cost price of INR 129 and the selling price of INR 191. 
Hint => 
Use a single print statement to display multiline text and variables.
Profit = selling price - cost price
Profit Percentage = profit / cost price * 100
I/P => NONE
O/P => 
The Cost Price is INR ___ and Selling Price is INR ___
The Profit is INR ___ and the Profit Percentage is ___
 */


public class Problem4 {
    public static void main(String[] args) {
        int cp = 129;
        int sp = 191;
        int profit = sp-cp;
        double profitpercentage = (profit*100.0)/cp;

        System.out.print("The Cost Price is INR "+cp+  " and Selling Price is INR "+sp+ "\nThe Profit is INR " +profit+ " and the profit percentage is " +profitpercentage);
    }
}
