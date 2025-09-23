public class PriorityExample {
    public static void main(String[] args) {

        Thread importantThread = new Thread(() -> {
            System.out.println("Important thread running.");
        });

        Thread lessImportantThread = new Thread(() -> {
            System.out.println("Less important thread running.");
        });

        // Suggest a high priority for the first thread
        importantThread.setPriority(Thread.MAX_PRIORITY);

        // Suggest a low priority for the second thread
        lessImportantThread.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Important thread priority: " + importantThread.getPriority());
        System.out.println("Less important thread priority: " + lessImportantThread.getPriority());

        // The OS may or may not run importantThread first.
        importantThread.start();
        lessImportantThread.start();
    }
}