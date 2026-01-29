/*An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete
Hint => 
Take user input for 3 sides of a triangle 
The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter
Write a Method to compute the number of rounds user needs to do to complete 5km run
 */
import java.util.Scanner;
public class athlete {
   static double numberOfRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000 / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double rounds = numberOfRounds(a, b, c);
        System.out.println(rounds);
        sc.close();
    } 
}
