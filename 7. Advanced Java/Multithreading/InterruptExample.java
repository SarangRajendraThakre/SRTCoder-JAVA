public class InterruptExample {
    public static void main(String[] args) throws InterruptedException {

        Thread workerThread = new Thread(() -> {
            // Keep working until the interrupted flag is set
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Worker: I'm working...");
                try {
                    // Pausing for a second. If interrupted, this will throw an exception.
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // This block is executed when another thread calls interrupt() on this one.
                    System.out.println("Worker: I've been told to stop!");

                    // It's a convention to restore the interrupted status after catching
                    Thread.currentThread().interrupt();

                    // Exit the loop
                    break;
                }
            }
            System.out.println("Worker: Shutting down.");
        });

        workerThread.start();

        // Let the worker run for a couple of seconds
        Thread.sleep(2500);

        // Now, signal the worker thread to stop
        System.out.println("Main: Interrupting the worker thread.");
        workerThread.interrupt();
    }
}