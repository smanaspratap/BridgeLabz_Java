package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*To make the pattern for a valid E-mail*/

public class ValidEmail {
    //Check for the entered string and the pattern
    public static void check(String regex, String str){
        Pattern p = Pattern.compile(regex);
        Matcher m= p.matcher(str);
        boolean match= m.matches();
        System.out.println(match);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        //Pattern for the valid Email. To Implement a . we have to add \\.
        String regex="^[a-zA-Z0-9_.$-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";
        System.out.println("enter string");
        String str=sc.nextLine();

        ValidEmail.check(regex,str);
    }
}
