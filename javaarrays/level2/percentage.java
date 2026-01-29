import java.util.Scanner;

/* 8. Create a program to take input marks of students in 3 subjects physics, chemistry, and maths.
Compute the percentage and then calculate the grade
*/
public class percentage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt(); // [cite: 195]
        
        // Arrays for data [cite: 196]
        double[] physics = new double[n], chemistry = new double[n], maths = new double[n];
        double[] percentage = new double[n];
        char[] grades = new char[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i+1) + " marks (Phy, Chem, Math): ");
            physics[i] = input.nextDouble();
            chemistry[i] = input.nextDouble();
            maths[i] = input.nextDouble();
            
            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) { // [cite: 198]
                System.out.println("Enter positive marks.");
                i--; continue;
            }
            
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0; // [cite: 199]
            
            // Grading logic [cite: 193]
            if (percentage[i] >= 80) grades[i] = 'A';
            else if (percentage[i] >= 70) grades[i] = 'B';
            else if (percentage[i] >= 60) grades[i] = 'C';
            else if (percentage[i] >= 50) grades[i] = 'D';
            else if (percentage[i] >= 40) grades[i] = 'E';
            else grades[i] = 'R';
        }
        
        // Display results [cite: 200]
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i+1) + " Percentage: " + percentage[i] + "% Grade: " + grades[i]);
        }
        input.close();
    }
}