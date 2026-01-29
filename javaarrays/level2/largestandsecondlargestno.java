import java.util.Scanner;

/* 3. Create a program to store the digits of the number in an array and find the largest and
second largest element of the array.
*/
public class largestandsecondlargestno {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = input.nextLong(); // Using long for larger numbers
        
        int maxDigit = 10; // Initial max size
        int[] digits = new int[maxDigit];
        int index = 0; // Array index tracker
        
        // Extract digits and store in array
        while (number != 0) {
            if (index == maxDigit) { // Break if array is full
                break;
            }
            digits[index] = (int)(number % 10);
            number /= 10;
            index++;
        }
        
        // Variables for largest and second largest
        int largest = -1;
        int secondLargest = -1;
        
        // Loop through the stored digits
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        // Display results
        System.out.println("Largest Digit: " + largest);
        System.out.println("Second Largest Digit: " + secondLargest);
        
        input.close();
    }
}