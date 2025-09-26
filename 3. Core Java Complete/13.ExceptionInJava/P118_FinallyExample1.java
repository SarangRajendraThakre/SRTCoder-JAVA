package ExceptionInJava;


class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("try");
            System.out.println(10 / 0); // Throws ArithmeticException
        } catch (ArithmeticException ae) {
            System.out.println("catch block");
        } finally {
            // This finally block might not complete because this is a daemon thread.
            System.out.println("finally block");
            try {
                Thread.sleep(5000); // Attempt to sleep
                System.out.println("Daemon thread finished sleeping."); // This is unlikely to be printed
            } catch (InterruptedException ie) {
                System.out.println("InterruptedException handled");
            }
        }
    }
}

public class P118_FinallyExample1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.setDaemon(true); // Mark t1 as a background thread.
        t1.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("main " + i);
            Thread.sleep(500);
        }
        // Main thread ends here, so the JVM will shut down.
    }
}