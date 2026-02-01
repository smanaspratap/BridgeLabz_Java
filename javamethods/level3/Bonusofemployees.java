/*Create a program to find the bonus of 10 employees based on their years of service as well as the total bonus amount the 10-year-old company Zara has to pay as a bonus, along with the old and new salary.
Hint => 
Zara decides to give a bonus of 5% to employees whose year of service is more than 5 years or 2% if less than 5 years
Create a Method to determine the Salary and years of service and return the same. Use the Math.random() method to determine the 5-digit salary for each employee and also use the random method to determine the years of service. Define 2D Array to save the salary and years of service.
Write a Method to calculate the new salary and bonus based on the logic defined above and return the new 2D Array of the latest salary and bonus amount 
Write a Method to Calculate the sum of the Old Salary, the Sum of the New Salary, and the Total Bonus Amount and display it in a Tabular Format
 */
public class P11_Bonus {

    public static void main(String[] args) {

        // Loop to generate data for 10 employees
        for (int i = 1; i <= 10; i++) {

            // Generate a random salary between 10,000 and 1,00,000
            double salary = 10000 + Math.random() * 90000;

            // Generate random years of service between 0 and 9
            int years = (int) (Math.random() * 10);

            // Calculate bonus:
            // If years of service > 5, bonus is 5% of salary
            // Otherwise, bonus is 2% of salary
            double bonus = years > 5 ? salary * 0.05 : salary * 0.02;

            // Print employee details:
            // Old salary, bonus amount, and new salary after bonus
            System.out.println(
                "Emp " + i +
                " Old: " + salary +
                " Bonus: " + bonus +
                " New: " + (salary + bonus)
            );
        }
    }
}
