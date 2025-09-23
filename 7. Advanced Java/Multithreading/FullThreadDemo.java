/**
 * This program demonstrates many core concepts of the java.lang.Thread class
 * in a single, cohesive example.
 *
 * It features:
 * 1. A Main Thread: The orchestrator that starts and manages other threads.
 * 2. A Worker Thread: A standard user thread that performs a simulated task.
 * 3. A Monitor Thread: A daemon thread that reports on the worker's status.
 *
 * Concepts demonstrated include:
 * - Thread creation with names (Thread(Runnable, String))
 * - setDaemon(), isDaemon()
 * - setPriority(), getPriority()
 * - start(), run()
 * - isAlive(), getState()
 * - Thread.sleep()
 * - interrupt() and handling InterruptedException
 * - join() (timed and indefinite)
 * - Thread.currentThread()
 */
public class FullThreadDemo {

    public static void main(String[] args) {

        System.out.println("--- Program Start ---");
        System.out.println("Main thread running: " + Thread.currentThread().getName());

        // 1. Create a worker thread
        Runnable workerTask = () -> {
            try {
                System.out.printf("✅ Worker thread '%s' has started.%n", Thread.currentThread().getName());
                for (int i = 1; i <= 5; i++) {
                    System.out.printf("   -> Worker is on step %d.%n", i);
                    Thread.sleep(1000); // Simulate one second of work
                }
                System.out.println("✅ Worker thread finished its task normally.");
            } catch (InterruptedException e) {
                // This block executes if another thread calls interrupt() on this one
                System.out.println("🛑 Worker thread was interrupted and is stopping.");
            }
        };
        Thread workerThread = new Thread(workerTask, "My-Worker-Thread");


        // 2. Create a daemon monitor thread
        // This thread will not prevent the program from exiting.
        Thread monitorThread = new Thread(() -> {
            // The monitor will watch the worker thread as long as it's alive
            while (workerThread.isAlive()) {
                try {
                    System.out.printf("   [Monitor]: Worker state is %s%n", workerThread.getState());
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                    // Daemon threads often don't need cleanup, but handling is good practice
                }
            }
        }, "Daemon-Monitor");


        // 3. Configure threads BEFORE starting
        workerThread.setPriority(Thread.MAX_PRIORITY); // Suggest this is important
        monitorThread.setDaemon(true); // This is a background task

        System.out.println("\n--- Configuration ---");
        System.out.printf("Worker initial state: %s, isAlive: %s, Priority: %d%n",
                workerThread.getState(), workerThread.isAlive(), workerThread.getPriority());
        System.out.printf("Monitor isDaemon: %s%n", monitorThread.isDaemon());


        // 4. Start the threads
        System.out.println("\n--- Starting Threads ---");
        workerThread.start();
        monitorThread.start();


        // 5. Interact with the worker thread from the main thread
        try {
            System.out.println("Main thread will now do a timed join on the worker for 2 seconds.");
            workerThread.join(2000); // Wait for a maximum of 2 seconds

            if (workerThread.isAlive()) {
                System.out.println("Main thread's timed join finished, but the worker is still alive.");
                System.out.println("Main thread will now interrupt the worker.");
                workerThread.interrupt(); // Send the interrupt signal
            }

            System.out.println("Main thread will now join indefinitely, waiting for worker to terminate.");
            workerThread.join(); // Wait until the worker thread is completely finished

        } catch (InterruptedException e) {
            System.err.println("Main thread was interrupted.");
        }


        // 6. Final status check
        System.out.println("\n--- Final Status ---");
        System.out.printf("Worker final state: %s, isAlive: %s%n",
                workerThread.getState(), workerThread.isAlive());

        System.out.println("Main thread is finished. Program will now exit.");
        System.out.println("(The daemon monitor thread will be terminated automatically by the JVM)");
    }
}