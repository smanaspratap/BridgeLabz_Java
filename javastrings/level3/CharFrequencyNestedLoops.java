/*
Write a program to find the frequency of characters in a string using nested loops
*/
import java.util.*;
public class CharFrequencyNestedLoops{
public static void main(String[]a){
Scanner s=new Scanner(System.in);
char[] t=s.nextLine().toCharArray();
int n=t.length;
int[] f=new int[n];
for(int i=0;i<n;i++){
f[i]=1;
for(int j=i+1;j<n;j++)if(t[i]==t[j]){f[i]++;t[j]='0';}
}
for(int i=0;i<n;i++)if(t[i]!='0')System.out.println(t[i]+" "+f[i]);
}
}