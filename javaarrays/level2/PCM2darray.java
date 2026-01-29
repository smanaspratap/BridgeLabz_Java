import java.util.Scanner;

/* 9. Rewrite the above program to store the marks of the students in physics, chemistry, and
maths in a 2D array and then compute the percentage and grade
*/
public class PCM2darray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();
        
        // 2D Array for marks: [n][3] [cite: 203]
        double[][] marks = new double[n][3];
        double[] percentage = new double[n];
        char[] grades = new char[n];
        
        for (int i = 0; i < n; i++) {
            double sum = 0;
            System.out.println("Enter marks for student " + (i+1) + " (Phy, Chem, Math): ");
            for (int j = 0; j < 3; j++) {
                marks[i][j] = input.nextDouble();
                sum += marks[i][j];
            }
            
            percentage[i] = sum / 3.0; // [cite: 204]
            if (percentage[i] >= 80) grades[i] = 'A';
            else if (percentage[i] >= 70) grades[i] = 'B';
            else if (percentage[i] >= 60) grades[i] = 'C';
            else if (percentage[i] >= 50) grades[i] = 'D';
            else if (percentage[i] >= 40) grades[i] = 'E';
            else grades[i] = 'R';
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i+1) + " Grade: " + grades[i]);
        }
        input.close();
    }
}