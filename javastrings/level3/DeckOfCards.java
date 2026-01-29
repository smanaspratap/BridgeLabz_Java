/*
Write a program to create a deck of cards, shuffle and distribute them to players
*/
import java.util.*;
public class DeckOfCards{
public static void main(String[]a){
String[] s={"Hearts","Diamonds","Clubs","Spades"};
String[] r={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
int n=s.length*r.length;
String[] deck=new String[n];
int k=0;
for(String x:s)for(String y:r)deck[k++]=y+" of "+x;
for(int i=0;i<n;i++){
int j=i+(int)(Math.random()*(n-i));
String t=deck[i];deck[i]=deck[j];deck[j]=t;
}
Scanner sc=new Scanner(System.in);
int p=sc.nextInt(),c=n/p,idx=0;
for(int i=0;i<p;i++){
System.out.println("Player "+(i+1));
for(int j=0;j<c;j++)System.out.println(deck[idx++]);
}
}
}