/*An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete
Hint => 
Take user input for 3 sides of a triangle 
The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter
Write a Method to compute the number of rounds user needs to do to complete 5km run
 */
import java.util.Scanner;

public class athlete {

    // This static method calculates the number of rounds an athlete must run
    // a, b, c represent the three sides of a triangular track
    static double numberOfRounds(double a, double b, double c) {

        // Calculate the perimeter of the triangular track
        double perimeter = a + b + c;

        // Total distance to be covered is 5000 meters
        // Number of rounds = total distance / perimeter of the track
        return 5000 / perimeter;
    }

    public static void main(String[] args) {

        // Create a Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Read the three side lengths of the triangular track
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        // Call the method to calculate number of rounds
        double rounds = numberOfRounds(a, b, c);

        // Print the number of rounds required
        System.out.println(rounds);

        // Close the Scanner to free resources
        sc.close();
    }
}
