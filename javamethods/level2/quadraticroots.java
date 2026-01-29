/*Write a program Quadratic to find the roots of the equation ax2+ bx + c. Use Math functions Math.pow() and Math.sqrt()
Hint => 
Take a, b, and c as input values to find the roots of x.
The roots are computed using the following formulae
delta = b2+ 4*a*c
If delta is positive the find the two roots using formulae 
root1 of x = (-b + delta)/(2*a) 
root1 of x = (-b - delta)/(2*a)
If delta is zero then there is only one root of x  
root of x = -b/(2*a)
If delta is negative return empty array or nothing 
Write a Method to find find the roots of a quadratic equation and return the roots
 */
import java.util.*;
public class quadraticroots {
    static double[] roots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta > 0) return new double[]{(-b + Math.sqrt(delta)) / (2 * a), (-b - Math.sqrt(delta)) / (2 * a)};
        else if (delta == 0) return new double[]{ -b / (2 * a) };
        else return new double[0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        System.out.println(Arrays.toString(roots(a, b, c)));
        sc.close();
    }
}
