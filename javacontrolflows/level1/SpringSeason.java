/*Write a program SpringSeason that takes two int values month and day from the command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”. 
Hint => 
Spring Season is from March 20 to June 20
 */


public class SpringSeason {

    public static void main(String[] args) {

        // Reading month from command-line arguments
        int month = Integer.parseInt(args[0]);

        // Reading day from command-line arguments
        int day = Integer.parseInt(args[1]);

        // Checking if the given date falls in the Spring season
        // Spring is from March 20 to June 20
        if ((month == 3 && day >= 20) ||   // March 20 onwards
            (month == 4) ||                // Entire April
            (month == 5) ||                // Entire May
            (month == 6 && day <= 20)) {   // Up to June 20

            System.out.println("Its a Spring Season");
        }
        // If the date does not fall in the Spring season
        else {
            System.out.println("Not a Spring Season");
        }
    }
}
