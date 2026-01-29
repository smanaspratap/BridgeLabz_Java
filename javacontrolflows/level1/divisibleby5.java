// Write a program to check if a number is divisible by 5
// I/P => number
// O/P => Is the number ___ divisible by 5? ___


import java.util.Scanner;
public class divisibleby5 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        if(n%5 == 0){
            System.out.println("Number is Div by 5");
        }else{
            System.out.println("Not Div");
        }
        inp.close();
    }
}
