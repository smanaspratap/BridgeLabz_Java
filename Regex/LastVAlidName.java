package Regex;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*To make a pattern for a Valid Name.*/
public class LastVAlidName {
    //Regex pattern and matcher.
    public static void check(String re, String str){
        Pattern p= Pattern.compile(re);
        Matcher m = p.matcher(str);
        boolean match= m.matches();
        System.out.println(match);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        //Pattern for the Valid Name
        String regex="^[A-z][a-z]{2,} [A-z][a-z]{2,}";

        System.out.println("Enter string");
        String str = sc.nextLine();

        LastVAlidName.check(regex,str);
    }


}
