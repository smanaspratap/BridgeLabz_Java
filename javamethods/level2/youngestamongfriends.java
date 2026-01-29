/*Create a program to find the youngest friends among 3 Amar, Akbar and Anthony based on their ages and tallest among the friends based on their heights and display it
Hint => 
Take user input for age and height for the 3 friends and store it in two arrays each to store the values for age and height of the 3 friends
Write a Method to find the youngest of the 3 friends
Write a Method to find the tallest of the 3 friends
 */
import java.util.*;
public class youngestamongfriends {
    static int youngest(int[] age) {
        return Math.min(age[0], Math.min(age[1], age[2]));
    }
    static int tallest(int[] h) {
        return Math.max(h[0], Math.max(h[1], h[2]));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[3];
        int[] height = new int[3];
        for (int i = 0; i < 3; i++) age[i] = sc.nextInt();
        for (int i = 0; i < 3; i++) height[i] = sc.nextInt();
        System.out.println("Youngest = " + youngest(age));
        System.out.println("Tallest = " + tallest(height));
        sc.close();
    }
}
