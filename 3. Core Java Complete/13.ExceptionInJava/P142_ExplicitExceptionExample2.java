package ExceptionInJava;


public class P142_ExplicitExceptionExample2 {
    public static void main(String[] args) {
        System.out.println("main starts");
        try {
            // This exception is manually thrown...
            throw new ArithmeticException("Logical Mistake");
        } catch (ArithmeticException e) {
            // ...and immediately caught here.
            System.out.println(e.getMessage());
        }
        System.out.println("main ends");
    }
}