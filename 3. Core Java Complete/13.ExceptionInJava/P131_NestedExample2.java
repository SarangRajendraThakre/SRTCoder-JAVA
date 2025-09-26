package ExceptionInJava;

public class P131_NestedExample2 {

    public static void main(String[] args) {
        try {
            System.out.println("outer try");
            // 1. First exception is thrown here.
            System.out.println(10 / 0);
        } catch (ArithmeticException ae) {
            System.out.println("outer catch");
            try {
                System.out.println("inner try");
                // 2. A new exception is thrown here.
                System.out.println(10 / 0);
            } catch (NullPointerException npe) {
                // This doesn't match the new exception.
                System.out.println("inner catch");
            } finally {
                // 3. This inner finally executes before the new exception propagates.
                System.out.println("inner finally");
            }
        } catch (Exception e) {
            // This is unreachable in this specific corrected code but shows valid syntax.
            System.out.println("Exception");
        } finally {
            // 4. This outer finally executes before the program crashes.
            System.out.println("outer finally");
        }
    }
}