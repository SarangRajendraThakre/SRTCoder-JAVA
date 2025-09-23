package Lock;

public class IllegalMonitorDemo {

    public static void main(String[] args) {
        Object lockObject = new Object();

        System.out.println("Attempting to call wait() without owning the lock...");

        try {
            // This line will throw the exception because we are not
            // inside a synchronized block for 'lockObject'.
            lockObject.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IllegalMonitorStateException e) {
            System.err.println("\nCaught the exception as expected!");
            System.err.println(e);
        }
    }
}