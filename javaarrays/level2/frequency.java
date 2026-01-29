import java.util.Scanner;

/* 10. Create a program to take a number as input find the frequency of each digit in the number
using an array and display the frequency of each digit
*/
public class frequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = input.nextLong(); // [cite: 212]
        
        // Frequency array for digits 0-9 [cite: 217]
        int[] frequency = new int[10];
        
        long temp = Math.abs(number); // Handle negative inputs
        if (temp == 0) frequency[0] = 1;
        
        while (temp > 0) { // [cite: 218]
            int digit = (int)(temp % 10);
            frequency[digit]++; // Increase frequency [cite: 218]
            temp /= 10;
        }
        
        // Display frequency [cite: 219]
        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }
        input.close();
    }
}