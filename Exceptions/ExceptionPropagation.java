package exceptions;
/*
 * Exception Propagation Demo - Method Call Chain
 * This program demonstrates how exceptions propagate through method calls
 * Exception travels from method1 -> method2 -> main
 */

public class ExceptionPropagation {
    
    // Method that throws ArithmeticException
    public static void method1() {
        System.out.println("Inside method1()");
        // This will throw ArithmeticException
        int result = 10 / 0;
        System.out.println("Result: " + result); // This line won't execute
    }
    
    // Method that calls method1 - exception propagates through this
    public static void method2() {
        System.out.println("Inside method2()");
        // Calling method1 - exception will propagate from here
        method1();
        System.out.println("Back in method2()"); // This line won't execute
    }
    
    public static void main(String[] args) {
        System.out.println("===== Exception Propagation =====\n");
        
        System.out.println("Inside main()");
        
        try {
            // Calling method2 which calls method1
            method2();
            System.out.println("Back in main()"); // This line won't execute
            
        } catch (ArithmeticException e) {
            // Exception is caught here after propagating through method chain
            System.out.println("\nHandled exception in main");
            System.out.println("Exception propagated: method1() -> method2() -> main()");
        }
        
        System.out.println("\nProgram continues normally after exception handling");
    }
}
