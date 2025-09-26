package ExceptionInJava;

public class P112_Try_Catch {
    public static void main(String[] args) {
        System.out.println("Hiiii");
        try {
            System.out.println("Outer try");
            // The program pauses here for 2 seconds.
            // Since it is not interrupted, no exception is thrown.
            Thread.sleep(2000); 
        } catch (InterruptedException ie) {
            // This entire block is skipped because no exception occurred.
            System.out.println("Outer catch");
            try {
                System.out.println("Inner try");
                System.out.println(10 / 0);
            } catch (ArithmeticException ae) {
                System.out.println("Inner catch");
            }
        }
        System.out.println("Bye");
    }
}