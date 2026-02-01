import java.util.Scanner;

/* 1. Create a program to find the bonus of 10 employees based on their years of service and the
total bonus amount the company Zara has to pay, along with the old and new salary. [cite: 116]
*/
class Bonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Define arrays to save salary, years of service, new salary, and bonus [cite: 119, 120]
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] newSalaries = new double[10];
        double[] bonuses = new double[10];
        
        // Variables for totals [cite: 120]
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        System.out.println("Enter details for 10 employees:");

        // Loop to take input [cite: 121]
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            
            System.out.print("Enter current salary: ");
            double salary = input.nextDouble();
            
            System.out.print("Enter years of service: ");
            double years = input.nextDouble();

            // Validate input. If invalid, ask again by decrementing index [cite: 122, 123]
            if (salary <= 0 || years < 0) {
                System.out.println("Invalid input. Please enter positive values.");
                i--; 
                continue;
            }

            salaries[i] = salary;
            yearsOfService[i] = years;
        }

        // Loop to calculate bonus and new salary [cite: 124]
        for (int i = 0; i < 10; i++) {
            // 5% bonus if service > 5 years, else 2% [cite: 118]
            if (yearsOfService[i] > 5) {
                bonuses[i] = salaries[i] * 0.05;
            } else {
                bonuses[i] = salaries[i] * 0.02;
            }

            newSalaries[i] = salaries[i] + bonuses[i];

            // Accumulate totals [cite: 126]
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        // Print results [cite: 127]
        System.out.println("\n--- Summary ---");
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        
        input.close();
    }
}
