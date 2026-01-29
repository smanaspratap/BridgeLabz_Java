/*Write a program to generate a six-digit OTP number using Math.random() method. Validate the numbers are unique by generating the OTP number 10 times and ensuring all the 10 OTPs are not the same
Hint => 
Write a method to Generate a 6-digit OTP number using Math.random() 
Create an array to save the OTP numbers generated 10 times
Write a method to ensure that the OTP numbers generated are unique. If unique return true else return false
 */
public class P7_OTP {
    static int generate(){
        return 100000+(int)(Math.random()*900000);
    }
    public static void main(String[] args){
        for(int i=0;i<10;i++) System.out.println(generate());
    }
}
