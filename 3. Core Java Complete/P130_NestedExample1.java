
public class P130_NestedExample1 {
    public static void main(String[] args) {
        try {
            System.out.println("outer try");
            // 1. First exception is thrown here.
            System.out.println(10 / 0);
        } catch (ArithmeticException ae) {
            System.out.println("outer catch");
            try {
                System.out.println("inner try");
                // 2. A new, unhandled exception is thrown here.
                System.out.println(10 / 0);
            } catch (NullPointerException npe) {
                // This does not match the exception, so it's skipped.
                System.out.println("inner catch");
            }
        } finally {
            // 3. This runs before the program crashes from the unhandled exception.
            System.out.println("outer finally");
        }
    }
}