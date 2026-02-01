/*Write a program to take user input for 5 numbers and check whether a number is positive, 
negative, or zero. Further for positive numbers check if the number is even or odd. 
Finally compare the first and last elements of the array and display if they equal, 
greater or less
Hint => 
Define an integer array of 5 elements and get user input to store in the array.
Loop through the array using the length If the number is positive, check for even or odd numbers and print accordingly
If the number is negative, print negative. Else if the number is zero, print zero. 
Finally compare the first and last element of the array and display if they equal, greater or less
 */


import java.util.*; // import utility classes (Scanner)

public class Evenodd{ // class to check positive/negative/zero and even/odd
    public static void main(String[] args) {
        // create a Scanner to read user input from console
        Scanner in = new Scanner(System.in);

        // define an integer array of 5 elements
        int[] arr = new int[5];

        // read 5 numbers from the user and store them in the array
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": "); // prompt
            arr[i] = in.nextInt(); // read next integer
        }

        // iterate over the array and check each number
        for (int num : arr) {
            if (num > 0) { // positive number
                // check if positive number is even or odd
                if (num % 2 == 0)
                    System.out.println(num + " is positive and even");
                else
                    System.out.println(num + " is positive and odd");
            } else if (num < 0) { // negative number
                System.out.println(num + " is negative");
            } else { // num == 0
                System.out.println(num + " is zero");
            }
        }

        // compare first and last elements of the array
        if (arr[0] == arr[arr.length - 1])
            System.out.println("First and last elements are equal");
        else if (arr[0] > arr[arr.length - 1])
            System.out.println("First element is greater");
        else
            System.out.println("Last element is greater");

        // close the Scanner to free resources
        in.close();
        
    }
}