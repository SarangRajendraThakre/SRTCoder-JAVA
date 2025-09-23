package Lock;

public class CorrectMonitorDemo {

    public static void main(String[] args) throws InterruptedException {
        Object lockObject = new Object();

        System.out.println("Attempting to call wait() correctly...");

        // First, acquire the lock on the object.
        synchronized (lockObject) {
            System.out.println("Lock acquired. Now calling wait()...");
            // This is now legal and the thread will wait.
            // (It will wait forever unless another thread calls notify()).
            lockObject.wait();
        }
        System.out.println("This line will never be reached in this example.");
    }
}