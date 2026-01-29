/* Create a program to find the total income of a person by taking salary and bonus from user
Hint => 
Create a variable named salary and take user input.
Create another variable bonus and take user input.
Compute income by adding salary and bonus and print the result
I/P => salary, bonus
O/P => The salary is INR ___ and bonus is INR ___. Hence Total Income is INR ___
*/


import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double salary;
        double bonus;

        System.out.print("Enter salary: ");
        salary = input.nextDouble();

        System.out.print("Enter bonus: ");
        bonus = input.nextDouble();

        double totalIncome = salary + bonus;

        System.out.println(
            "The salary is INR " + salary +
            " and bonus is INR " + bonus +
            ". Hence Total Income is INR " + totalIncome
        );

        input.close();
    }
}

