import java.util.Scanner;

/* 4. Rework the program 2, especially the Hint f where if index equals maxDigit, we break from the loop.
Here we want to modify to Increase the size of the array i,e maxDigit by 10 if the index is equal to maxDigit.
*/
public class maxDigit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a large number: ");
        String numStr = input.next(); // Taking as string to handle extremely long inputs
        
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        
        for (int i = 0; i < numStr.length(); i++) {
            // Increase size if index is equal to maxDigit [cite: 153]
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                // Copy current digits to temp array [cite: 154]
                System.arraycopy(digits, 0, temp, 0, digits.length);
                digits = temp; // Assign current digits to temp [cite: 154]
            }
            digits[index++] = Character.getNumericValue(numStr.charAt(i));
        }
        
        int largest = -1, secondLargest = -1;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
        input.close();
    }
}