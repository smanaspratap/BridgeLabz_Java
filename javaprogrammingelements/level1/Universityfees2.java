/* Write a new program similar to the program # 6 but take user input for Student Fee and University Discount
Hint => 
Create a variable named fee and take user input for fee.
Create another variable discountPercent and take user input.
Compute the discount and assign it to the discount variable.
Compute and print the fee you have to pay by subtracting the discount from the fee.
I/P => fee, discountPrecent
O/P => The discount amount is INR ___ and final discounted fee is INR ___
*/
import java.util.Scanner;

public class Problem9 {
    public static void main(String[]args){
        Scanner Input = new Scanner(System.in);

        double fee;
        System.out.print("Enter the Fee amount ");
        fee = Input.nextDouble();

        double discountpercentage = 10;

        double feeafterdiscount = (fee *discountpercentage)/100;

        double finalfee = fee - feeafterdiscount;

        System.out.print("The Total fees of this University is "+fee+ ". The discount amount is INR "+feeafterdiscount+ " and final discounted fee is INR "+finalfee);
        
        Input.close();

    }
    
}
