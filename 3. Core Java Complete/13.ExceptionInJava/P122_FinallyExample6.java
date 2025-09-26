package ExceptionInJava;



public class P122_FinallyExample6 {

    public static void main(String[] args) {
        System.out.println("Execution starts");
        m1();
        System.out.println("Execution ends");
    }

    public static void m1() {
        try {
            System.out.println("try");
            // This throws an exception.
            System.out.println(10 / 0);
        } catch (ArithmeticException ae) {
            System.out.println("catch block");
            // The method prepares to return from here...
            return;
        } finally {
            // ...but this finally block is guaranteed to execute first.
            System.out.println("finally block");
        }
    }
}