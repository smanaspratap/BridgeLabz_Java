/*Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.
Hint => 
Create a method to define the random 2-digit age of several students provided as method parameters and return a 1D array of ages of n students
Create a method that takes an array of age as a parameter and returns a 2D String array of age and a boolean true or false to indicate can and cannot vote. Inside the method firstly validate the age for a negative number, if a negative cannot vote. For valid age check for age is 18 or above to set true to indicate can vote.
Create a method to display the 2D array in a tabular format.
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
 */


import java.util.Scanner;

public class VotingCheck {
    static int[] generateAges(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int)(Math.random() * 90) + 10;
        return arr;
    }

    static String[][] checkVote(int[] ages) {
        String[][] res = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            res[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) res[i][1] = "false";
            else if (ages[i] >= 18) res[i][1] = "true";
            else res[i][1] = "false";
        }
        return res;
    }

    static void display(String[][] arr) {
        System.out.println("Age\tCanVote");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i][0] + "\t" + arr[i][1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ages = generateAges(n);
        String[][] res = checkVote(ages);
        display(res);
    }
}
