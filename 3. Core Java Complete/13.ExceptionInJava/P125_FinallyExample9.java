package ExceptionInJava;

public class P125_FinallyExample9 {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            // This throws an exception.
            System.out.println(10 / 0);
        } catch (ArithmeticException ae) {
            System.out.println("catch");
            // This is an infinite loop that traps the program.
            for (;;); 
        } finally {
            // This block is never reached because the catch block never finishes.
            System.out.println("finally block");
        }
    }
}