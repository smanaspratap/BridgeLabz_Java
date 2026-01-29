/*Write a program to find vowels and consonants in a string and display the count of  Vowels and Consonants in the string
 */
import java.util.*;
public class vowels {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char arr[] = s.toCharArray();
        int vowels = 0;
        int consonents = 0;

        for(int i = 0; i< arr.length; i++){
            char ch = arr[i];
            if(ch >= 'A' && ch<= 'Z' ){
                ch = (char)(ch+32);
            }
            if(ch >= 'a' && ch<= 'z'){
                if(ch == 'a'|| ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    vowels++;
                }
                else{
                    consonents++;
                }
            }
        }
        System.out.println(vowels);
        System.out.println(consonents);
        in.close();
    }    
}
