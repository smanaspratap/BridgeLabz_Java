/*Write a program to demonstrate NullPointerException. 
Hint => 
Write a Method to generate the Exception. Here define the variable text and initialize it to null. Then call one of the String Method to generate the exception
Write the Method to demonstrate NullPointerException. Here define the variable text and initialize it to null. Then write try catch block for handling the Exception while accessing one of the String method
From the main Firstly call the method to generate the Exception then refactor the code to call the method to handle the RuntimeException
 */

public class nullpoingteexception {
    static void generateException(){
        String text = null;
        System.out.println(text.length());

    }
    static void handleexception(){
        String text = null;
        try{
            System.out.println(text.length());
        }catch(NullPointerException e){
            System.out.println("NullPointerException caught and handled. ");
            System.out.println("Reason: You are trying to access method on a null value and an object. ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Generating NullPointerException: ");
        try{
            generateException();
        }catch(NullPointerException e){
            System.out.println("Exception Occured in generateException()");
        }
        System.out.println("Handling it");
        handleexception();
    }
}
