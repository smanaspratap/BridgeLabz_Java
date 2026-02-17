package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*To make a Regex pattern to validate a given name entered by a user*/
public class ValidName {
    public static void Check(String re , String str){
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(str);
        boolean matches = matcher.matches();
        System.out.println(matches);
    }
    public static void main(String[] args ){
        Scanner sc= new Scanner(System.in);
        //Pattern for a Valid Name
        String regex= "^[A-Z][a-z]{2,}$";

        System.out.println("enter string");
        String str= sc.nextLine();

        ValidName.Check(regex, str);
    }
}
