/*
Write a program to to check if a text is palindrome and display the result
*/
import java.util.*;
public class PalindromeCheck{
static boolean rec(String s,int i,int j){
if(i>=j)return true;
if(s.charAt(i)!=s.charAt(j))return false;
return rec(s,i+1,j-1);
}
public static void main(String[]a){
Scanner s=new Scanner(System.in);
String t=s.nextLine();
boolean r=true;
int i=0,j=t.length()-1;
while(i<j){if(t.charAt(i)!=t.charAt(j))r=false;i++;j--;}
System.out.println(r);
System.out.println(rec(t,0,t.length()-1));
String rev="";
for(int k=t.length()-1;k>=0;k--)rev+=t.charAt(k);
System.out.println(t.equals(rev));
}
}