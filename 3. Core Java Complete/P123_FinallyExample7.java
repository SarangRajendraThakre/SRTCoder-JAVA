

public class P123_FinallyExample7 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println("try block" + i);
                if (i == 2) {
                    // This throws an exception only when i is 2.
                    System.out.println(10 / 0);
                }
            } catch (ArithmeticException ae) {
                System.out.println("catch block");
                // The loop prepares to terminate here...
                break;
            } finally {
                // ...but this finally block is guaranteed to execute first.
                System.out.println("finally block");
            }
        }
    }
}