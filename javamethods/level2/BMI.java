/*An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in the team of 10 members. For this create a program to find the BMI and display the height, weight, BMI and status of each individual
Hint => 
Take user input in double for the weight (in kg) of the person and height (in cm) for the person and and store it in the corresponding 2D array of 10 rows and 3 columns. The First Column storing the weight, the second column storing the height in cm and the third column is the BMI
Create a Method to find the BMI of every person and populate the array. Use the formula BMI = weight / (height * height). Note unit is kg/m^2. For this convert cm to meter
Create a Method to determine the BMI status using the logic shown in the figure below. and return the array of all the persons BMI Status. 
 */
import java.util.*;
public class BMI {
    static double bmi(double w, double hcm) {
        double h = hcm / 100;
        return w / (h * h);
    }
    static String status(double b) {
        if (b < 18.5) return "Underweight";
        if (b < 25) return "Normal";
        if (b < 30) return "Overweight";
        return "Obese";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            double w = sc.nextDouble();
            double h = sc.nextDouble();
            double b = bmi(w, h);
            System.out.println(b + " " + status(b));
        }
        sc.close();
    }
}
