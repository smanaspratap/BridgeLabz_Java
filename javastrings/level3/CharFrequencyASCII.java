/*
Write a program to find the frequency of characters in a string using the charAt() method
*/
import java.util.*;

public class CharFrequencyASCII {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String t = s.nextLine();
        int[] f = new int[256];

        for (int i = 0; i < t.length(); i++) {
            f[t.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (f[i] > 0) {
                System.out.println((char) i + " " + f[i]);
            }
        }

        s.close();
    }
}
