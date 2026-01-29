import java.util.Scanner;

/* 2. Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on
their ages and the tallest among the friends based on their heights
*/
public class youngestfriends {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Arrays to store age and height for 3 friends
        int[] ages = new int[3];
        double[] heights = new double[3];
        String[] names = {"Amar", "Akbar", "Anthony"};
        
        // Take user input for age and height
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = input.nextInt();
            System.out.print("Enter height for " + names[i] + ": ");
            heights[i] = input.nextDouble();
        }
        
        // Find youngest
        int minAge = ages[0];
        String youngest = names[0];
        // Find tallest
        double maxHeight = heights[0];
        String tallest = names[0];
        
        for (int i = 1; i < 3; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngest = names[i];
            }
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallest = names[i];
            }
        }
        
        // Display results
        System.out.println("Youngest Friend: " + youngest + " (Age: " + minAge + ")");
        System.out.println("Tallest Friend: " + tallest + " (Height: " + maxHeight + ")");
        
        input.close();
    }
}