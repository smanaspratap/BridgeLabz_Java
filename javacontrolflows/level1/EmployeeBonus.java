/*Create a program to find the bonus of employees based on their years of service.
Hint => 
Zara decided to give a bonus of 5% to employees whose year of service is more than 5 years.
Take salary and year of service in the year as input.
Print the bonus amount.
 */

import java.util.Scanner;

public class EmployeeBonus {

    public static void main(String[] args) {

        // Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Reading the employee's salary
        double salary = sc.nextDouble();

        // Reading the number of years of service
        int years = sc.nextInt();

        // Checking if the employee is eligible for bonus
        if (years > 5) {

            // Calculating 5% bonus on salary
            double bonus = salary * 0.05;

            // Displaying the bonus amount
            System.out.println("Bonus Amount = " + bonus);
        }
        // If years of service is 5 or less
        else {
            System.out.println("No Bonus");
        }

        // Closing the scanner to release resources
        sc.close();
    }
}
