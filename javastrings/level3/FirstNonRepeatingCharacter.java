/*
Write a program to find the first non-repeating character in a string and show the result
*/
import java.util.*;

public class FirstNonRepeatingCharacter {

    static char find(String s) {
        int[] f = new int[256];

        for (int i = 0; i < s.length(); i++) {
            f[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (f[s.charAt(i)] == 1)
                return s.charAt(i);
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println(find(s.nextLine()));

        s.close();
    }
}
