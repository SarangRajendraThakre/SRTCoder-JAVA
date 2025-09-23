
public class P119_FinallyExample3 {
    public static void main(String[] args) {
        // 1. This line throws an unhandled exception immediately.
        System.out.println(10 / 0);

        // 2. This entire block is never executed.
        try {
            System.out.println("try");
            System.out.println("10/0");
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException handled");
        } finally {
            System.out.println("finally block");
        }
    }
}