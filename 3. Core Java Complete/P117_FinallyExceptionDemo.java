

public class P117_FinallyExceptionDemo {
    public static void main(String[] args) {
        try {
            System.out.println("1. Inside try block");
        } finally {
            System.out.println("2. Inside finally block");
            int result = 5 / 0; // Throws a new exception from finally
            System.out.println("This line is never reached.");
        }
        // There's no handler for the exception from 'finally', so the program crashes.
    }
}