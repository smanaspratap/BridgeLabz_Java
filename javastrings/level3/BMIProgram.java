/*
An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in a team of 10 members.
*/
import java.util.*;
public class BMIProgram{
static String status(double b){
if(b<18.5)return"Underweight";
if(b<25)return"Normal";
if(b<40)return"Overweight";
return"Obese";
}
static String[][] compute(double[][] hw){
String[][] r=new String[10][4];
for(int i=0;i<10;i++){
double h=hw[i][1]/100;
double bmi=hw[i][0]/(h*h);
r[i][0]=String.valueOf(hw[i][1]);
r[i][1]=String.valueOf(hw[i][0]);
r[i][2]=String.valueOf(bmi);
r[i][3]=status(bmi);
}
return r;
}
static void display(String[][] a){
System.out.println("Height Weight BMI Status");
for(int i=0;i<a.length;i++)
System.out.println(a[i][0]+" "+a[i][1]+" "+a[i][2]+" "+a[i][3]);
}
public static void main(String[]a){
Scanner s=new Scanner(System.in);
double[][] hw=new double[10][2];
for(int i=0;i<10;i++){hw[i][0]=s.nextDouble();hw[i][1]=s.nextDouble();}
display(compute(hw));
}
}