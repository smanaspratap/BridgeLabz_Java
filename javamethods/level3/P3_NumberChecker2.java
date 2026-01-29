/*Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
Hint => 
Method to find the count of digits in the number and a Method to Store the digits of the number in a digits array
Method to find the sum of the digits of a number using the digits array
Method to find the sum of the squares of the digits of a number using the digits array. Use Math.pow() method
Method to Check if a number is a harshad number using a digits array. A number is called a Harshad number if it is divisible by the sum of its digits. For e.g. 21
Method to find the frequency of each digit in the number. Create a 2D array to store the frequency with digit in the first column and frequency in the second column.
 */
public class P3_NumberChecker2 {
    static int[] digits(int n){
        String s=""+n; int[] d=new int[s.length()];
        for(int i=0;i<s.length();i++) d[i]=s.charAt(i)-'0';
        return d;
    }
    static int sum(int[] d){ int s=0; for(int x:d) s+=x; return s; }
    static int sumSquares(int[] d){ int s=0; for(int x:d) s+=x*x; return s; }
    static boolean isHarshad(int n,int[] d){ return n%sum(d)==0; }
    public static void main(String[] args){
        int n=21; int[] d=digits(n);
        System.out.println("Sum: "+sum(d));
        System.out.println("Sum Squares: "+sumSquares(d));
        System.out.println("Harshad: "+isHarshad(n,d));
    }
}
