package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*To make a pattern to Validate a password string entered by the User.*/
public class ValidPassword {
    public static void check(String regex, String str){
        Pattern p = Pattern.compile(regex);
        Matcher m= p.matcher(str);
        boolean match= m.matches();
        System.out.println(match);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        //Pattern for a Valid Name..
        String regex="^(?=.{8,}$)(?=.*[A-Z])(?=.*[\\d])(?=(?:.*[!@#$%^&*]){1}.*$)[A-Za-z\\d!@#$%^&*]+$";
        System.out.println("enter string");
        String str=sc.nextLine();

        ValidPassword.check(regex,str);
    }
}
