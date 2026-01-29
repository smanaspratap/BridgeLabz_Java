import java.util.Scanner;

/* 6. An organization took up an exercise to find the Body Mass Index (BMI) of all the persons in the team.
Find the BMI and display the height, weight, BMI and status.
*/
public class BMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = input.nextInt(); // [cite: 168]
        
        // Arrays for weight, height, BMI, and status [cite: 169]
        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] bmis = new double[n];
        String[] status = new String[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) and height (m) for person " + (i+1) + ": ");
            weights[i] = input.nextDouble(); // [cite: 170]
            heights[i] = input.nextDouble(); // [cite: 170]
            
            // BMI Formula: weight / (height * height)
            bmis[i] = weights[i] / (heights[i] * heights[i]); // [cite: 171]
            
            // Determine status [cite: 173, 174]
            if (bmis[i] <= 18.4) status[i] = "Underweight";
            else if (bmis[i] <= 24.9) status[i] = "Normal";
            else if (bmis[i] <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }
        
        // Display results [cite: 172]
        System.out.println("Ht\tWt\tBMI\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", heights[i], weights[i], bmis[i], status[i]);
        }
        input.close();
    }
}