/*Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
Hint => 
Method to Find the count of digits in the number
Method to Store the digits of the number in a digits array
Method to Check if a number is a duck number using the digits array. A duck number is a number that has a non-zero digit present in it
Method to check if the number is a armstrong number using the digits array. ​​Armstrong number is a number that is equal to the sum of its own digits raised to the power of the number of digits. Eg: 153 = 1^3 + 5^3 + 3^3
Method to find the largest and second largest elements in the digits array. Use Integer.MIN_VALUE to initialize the variable.
Method to find the the smallest and second smallest elements in the digits array. Use Integer.MAX_VALUE to initialize the variable.
 */
public class P2_NumberChecker1 {
    static int countDigits(int n){ return String.valueOf(n).length(); }
    static int[] digits(int n){
        String s=""+n; int[] d=new int[s.length()];
        for(int i=0;i<s.length();i++) d[i]=s.charAt(i)-'0';
        return d;
    }
    static boolean isDuck(int[] d){
        for(int x:d) if(x!=0) return true; return false;
    }
    static boolean isArmstrong(int n,int[] d){
        int p=d.length, s=0;
        for(int x:d) s+=Math.pow(x,p);
        return s==n;
    }
    public static void main(String[] args){
        int n=153;
        int[] d=digits(n);
        System.out.println("Digits: "+countDigits(n));
        System.out.println("Duck: "+isDuck(d));
        System.out.println("Armstrong: "+isArmstrong(n,d));
    }
}
