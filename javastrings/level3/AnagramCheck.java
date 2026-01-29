/*
Write a program to check if two texts are anagrams and display the result
*/
import java.util.*;

public class AnagramCheck {

    static boolean check(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] f = new int[256];

        for (int i = 0; i < a.length(); i++) {
            f[a.charAt(i)]++;
            f[b.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (f[i] != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(check(s.nextLine(), s.nextLine()));
        s.close();
    }
}
