public class SleepExample {
    public static void main(String[] args) {
        System.out.println("Starting countdown...");

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            try {
                // Pause the main thread for 1000 milliseconds (1 second)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // This block would run if another thread interrupted this one.
                System.out.println("The countdown was interrupted!");
                // It's good practice to restore the interrupted status
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Blast off!");
    }
}