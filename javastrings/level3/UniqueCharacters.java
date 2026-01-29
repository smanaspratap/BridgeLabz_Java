/*
Find unique characters in a string using the charAt() method and display the result
*/
import java.util.*;
public class UniqueCharacters{
static int len(String s){int c=0;for(char x:s.toCharArray())c++;return c;}
static char[] unique(String s){
int n=len(s);char[] r=new char[n];int k=0;
for(int i=0;i<n;i++){
char c=s.charAt(i);boolean f=true;
for(int j=0;j<i;j++)if(s.charAt(j)==c)f=false;
if(f)r[k++]=c;
}
return r;
}
public static void main(String[]a){
Scanner s=new Scanner(System.in);
char[] u=unique(s.nextLine());
for(char c:u)if(c!=0)System.out.print(c+" ");
}
}