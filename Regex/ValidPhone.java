package Regex;
/*To Validate a Phone Number entered by the User.*/
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPhone {
    public static void check(String regex, String str){
        Pattern p = Pattern.compile(regex);
        Matcher m= p.matcher(str);
        boolean match= m.matches();
        System.out.println(match);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter string");
        //To check for a Valid Phone Number
        String regex= "^[0-9]{2,} [0-9]{10}$";
        String str=sc.nextLine();

        ValidPhone.check(regex,str);
    }
}
