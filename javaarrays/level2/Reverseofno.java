import java.util.Scanner;

/* 5. Create a program to take a number as input and reverse the number.
To do this, store the digits of the number in an array and display the array in reverse order
*/
class reverseofno {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt(); // [cite: 159]
        
        // Find digit count [cite: 160]
        int temp = number;
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        
        // Save digits in array [cite: 162]
        int[] digits = new int[count];
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        
        // Reverse array [cite: 163]
        int[] reversed = new int[count];
        for (int i = 0; i < count; i++) {
            reversed[i] = digits[i]; // Digits are already in "last-first" order from % 10
        }
        
        // Display reversed order [cite: 164]
        System.out.print("Reversed Number: ");
        for (int val : reversed) {
            System.out.print(val);
        }
        input.close();
    }
}
