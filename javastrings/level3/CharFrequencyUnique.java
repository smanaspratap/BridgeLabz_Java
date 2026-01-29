/*
Write a program to find the frequency of characters in a string using unique characters
*/
import java.util.*;

public class CharFrequencyUnique {

    static char[] unique(String s) {
        char[] r = new char[s.length()];
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean f = true;

            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c)
                    f = false;
            }

            if (f)
                r[k++] = c;
        }

        return r;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String t = s.nextLine();
        int[] f = new int[256];

        for (int i = 0; i < t.length(); i++)
            f[t.charAt(i)]++;

        for (char c : unique(t)) {
            if (c != 0)
                System.out.println(c + " " + f[c]);
        }

        s.close();
    }
}
