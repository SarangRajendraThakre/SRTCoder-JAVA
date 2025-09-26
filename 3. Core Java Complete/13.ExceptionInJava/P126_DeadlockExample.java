package ExceptionInJava;

public class P126_DeadlockExample {
    public static void main(String[] args) throws InterruptedException {
        try {
            System.out.println("try");
            // This throws an exception.
            System.out.println(10 / 0);
        } catch (ArithmeticException ae) {
            System.out.println("catch");
            // This causes the main thread to wait for itself to die,
            // creating a deadlock.
            Thread.currentThread().join(); 
        } finally {
            // This block is never reached because the catch block is deadlocked.
            System.out.println("finally block");
        }
    }
}