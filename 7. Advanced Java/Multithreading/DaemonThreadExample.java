public class DaemonThreadExample {
    public static void main(String[] args) throws InterruptedException {

        Thread daemonThread = new Thread(() -> {
            try {
                // This loop will run as long as the main thread is alive
                while (true) {
                    System.out.println("Daemon thread is running...");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                // This exception will likely not be seen, as the JVM will exit abruptly.
            }
        });

        // Mark the thread as a daemon thread
        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("Main thread is running for 2 seconds and will then finish.");
        Thread.sleep(2000);

        System.out.println("Main thread is finishing. The application will now exit.");
        // The JVM sees that the only remaining thread is a daemon, so it shuts down.
    }
}