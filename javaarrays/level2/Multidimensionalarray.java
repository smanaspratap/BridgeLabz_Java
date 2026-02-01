import java.util.Scanner;

/* 7. Rewrite the above program using multi-dimensional array to store height, weight, and BMI in
2D array for all the persons
*/
class Multidimensionalarray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = input.nextInt(); // [cite: 182]
        
        // 2D array: [row][0]=weight, [row][1]=height, [row][2]=BMI [cite: 183, 185]
        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n]; // [cite: 186]
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and height for person " + (i+1) + ": ");
            personData[i][0] = input.nextDouble();
            personData[i][1] = input.nextDouble();
            
            if (personData[i][0] <= 0 || personData[i][1] <= 0) { // [cite: 187]
                System.out.println("Please enter positive values.");
                i--; continue;
            }
            
            // Calculate BMI and store in 2D array [cite: 188]
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            
            // Status [cite: 189]
            if (personData[i][2] <= 18.4) weightStatus[i] = "Underweight";
            else if (personData[i][2] <= 24.9) weightStatus[i] = "Normal";
            else if (personData[i][2] <= 39.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }
        
        // Display [cite: 190]
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i+1) + " BMI: " + personData[i][2] + " Status: " + weightStatus[i]);
        }
        input.close();
    }
}