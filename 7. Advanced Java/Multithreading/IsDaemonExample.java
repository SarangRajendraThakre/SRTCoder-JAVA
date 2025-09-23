public class IsDaemonExample {
    public static void main(String[] args) {

        Thread userThread = new Thread(() -> {
            // This is a standard user thread
        });

        Thread daemonThread = new Thread(() -> {
            // This will be a background daemon thread
        });

        // Mark the second thread as a daemon BEFORE starting it
        daemonThread.setDaemon(true);

        // Now, let's check their status
        System.out.println("userThread.isDaemon() -> " + userThread.isDaemon());
        System.out.println("daemonThread.isDaemon() -> " + daemonThread.isDaemon());
    }
}