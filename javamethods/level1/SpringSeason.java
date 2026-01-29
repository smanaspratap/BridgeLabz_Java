/*Write a program SpringSeason that takes two int values month and day from the command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”. 
Hint => Spring Season is from March 20 to June 20. Write a Method to check for Spring season and return a boolean true or false 
 */


import java.util.Scanner;

public class SpringSeason {

    static boolean isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();

        boolean result = isSpringSeason(month, day);

        if (result) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
        sc.close();
    }
}

