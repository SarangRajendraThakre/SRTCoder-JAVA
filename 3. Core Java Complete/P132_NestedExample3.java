
public class P132_NestedExample3 {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            // 1. This exception is thrown and handled.
            System.out.println(10 / 0);
        } catch (ArithmeticException ae) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
            // 2. A new, unhandled exception is thrown here, causing a crash.
            System.out.println(10 / 0);
        }
    }
}