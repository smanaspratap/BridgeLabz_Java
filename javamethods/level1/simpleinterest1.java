/*Write a program to input the Principal, Rate, and Time values and calculate Simple Interest.
Hint => 
Simple Interest = Principal * Rate * Time / 100
Take user input for principal, rate, time
Write a method to calculate the simple interest given principle, rate and time as parameters
Output “The Simple Interest is ___ for Principal ___, Rate of Interest ___ and Time ___”
 */
import java.util.*;
public class simpleinterest1{

    static double simpleinterest(double principle, double rate, double time){
        double simpleinterest = (principle*rate*time)/100;
        return simpleinterest;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double p = in.nextDouble();
        double r = in.nextDouble();
        double t = in.nextDouble();

        double ans = simpleinterest(p,r,t);
        System.out.println("The Simple Interest is " +ans+" for principal " +p+", Rate of Interest is "+r+"% and Time "+t+"." );
        in.close();
    }
}