public class AllThreadMethodsDemo {

    // This is our custom worker thread class
    static class WorkerThread extends Thread {

        public WorkerThread(String name) {
            // Method: setName() - Sets the thread's name via constructor
            super(name);
        }

        // Method: run() - The entry point for the new thread
        @Override
        public void run() {
            // Method: currentThread() and getName() - Get reference to and name of the current thread
            System.out.println(" " + Thread.currentThread().getName() + " has started.");

            // A loop to simulate some work
            for (int i = 1; i <= 5; i++) {
                System.out.println("   -> " + getName() + " is working, step " + i);
                try {
                    // Method: sleep() - Pause this thread's execution for 1 second
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // This block executes if another thread calls interrupt() on this one
                    System.out.println(" " + getName() + " was interrupted and will stop.");
                    return; // Exit the run() method to terminate the thread
                }
            }
            System.out.println(" " + getName() + " has finished its work normally.");
        }
    }

    public static void main(String[] args) {
        System.out.println(" Main thread is starting.");

        // Create a new thread object
        WorkerThread worker = new WorkerThread("Worker-007");

        // Method: setPriority() - Setting the worker's priority
        worker.setPriority(Thread.MAX_PRIORITY);
        System.out.println("   - Priority of " + worker.getName() + " is: " + worker.getPriority());

        // Method: getState() - Check state before starting
        System.out.println("   - State of " + worker.getName() + " before start(): " + worker.getState()); // NEW

        // Method: start() - Begins the thread execution
        worker.start();

        // Method: isAlive() - Check if the thread is running
        System.out.println("   - Is " + worker.getName() + " alive after start()? " + worker.isAlive());

        try {
            // Let the main thread sleep for a bit to observe the worker
            Thread.sleep(500);

            // Method: getState() - Worker will likely be sleeping
            System.out.println("   - State of " + worker.getName() + " during execution: " + worker.getState()); // TIMED_WAITING

            // Method: interrupt() - Signal the worker thread to stop
            System.out.println("   - Main thread is interrupting the worker.");
            worker.interrupt();

            // Method: join() - Main thread waits for the worker thread to die (terminate)
            System.out.println("   - Main thread is waiting for the worker to finish...");
            worker.join();
            System.out.println("   - Worker thread has finished.");

        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Method: isAlive() - Check again after the thread should have terminated
        System.out.println("   - Is " + worker.getName() + " alive after join()? " + worker.isAlive());

        // Method: getState() - Check the final state
        System.out.println("   - State of " + worker.getName() + " at the end: " + worker.getState()); // TERMINATED

        System.out.println(" Main thread has finished.");
    }
}