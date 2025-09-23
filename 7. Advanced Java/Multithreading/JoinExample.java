public class JoinExample {
    public static void main(String[] args) {
        System.out.println("Main thread started.");

        // Create a worker thread that simulates some work
        Thread workerThread = new Thread(() -> {
            try {
                System.out.println("Worker thread: Starting my task...");
                Thread.sleep(2000); // Simulate 2 seconds of work
                System.out.println("Worker thread: Finished my task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        workerThread.start(); // Start the worker thread

        try {
            // The main thread will pause here and wait for workerThread to die.
            workerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread: Worker has finished, I can now continue.");
    }
}