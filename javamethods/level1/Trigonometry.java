/*Write a program to calculate various trigonometric functions using Math class given an angle in degrees
Hint => 
Method to calculate various trigonometric functions, Firstly convert to radians and then use Math function to find sine, cosine and tangent.
public double[] calculateTrigonometricFunctions(double angle)
 */
import java.util.Scanner;

public class Trigonometry {

    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double angle = sc.nextDouble();

        double[] result = calculateTrigonometricFunctions(angle);

        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        sc.close();
    }
}
