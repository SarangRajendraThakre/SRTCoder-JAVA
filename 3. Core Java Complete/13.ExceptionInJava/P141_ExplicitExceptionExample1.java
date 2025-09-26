package ExceptionInJava;



public class P141_ExplicitExceptionExample1 {
    public static void main(String[] args) {
        System.out.println("main starts");
        
        // Manually throwing an exception with a custom message.
        throw new ArithmeticException("Logical Mistake");
        
        // This line is unreachable due to the exception thrown above.
        // System.out.println("main ends");
    }
}
