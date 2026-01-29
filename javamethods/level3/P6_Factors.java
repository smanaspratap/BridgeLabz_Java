/*Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
Hint => 
Method to find factors of a number and return them as an array. Note there are 2 for loops one for the count and another for finding the factor and storing in the array
Method to find the greates factor of a Number using the factors array
Method to find the sum of the factors using factors array and return the sum
Method to find the product of the factors using factors array and return the product
Method to find product of cube of the factors using the factors array. Use Math.pow() 
Method to Check if a number is a perfect number. Perfect numbers are positive integers that are equal to the sum of their proper divisors
Method to find the number is a abundant number. A number is called an abundant number if the sum of its proper divisors is greater than the number itself
Method to find the number is a deficient number. A number is called a deficient number if the sum of its proper divisors is less than the number itself
Method to Check if a number is a strong number. A number is called a strong number if the sum of the factorial of its digits is equal to the number itself
 */
public class P6_Factors {
    static int[] factors(int n){
        int c=0;
        for(int i=1;i<=n;i++) if(n%i==0) c++;
        int[] f=new int[c]; int j=0;
        for(int i=1;i<=n;i++) if(n%i==0) f[j++]=i;
        return f;
    }
    public static void main(String[] args){
        int n=6;
        int[] f=factors(n);
        System.out.print("Factors: ");
        for(int x:f) System.out.print(x+" ");
    }
}
