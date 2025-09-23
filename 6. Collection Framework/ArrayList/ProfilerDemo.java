public class ProfilerDemo {

    // This method is fast
    public static void fastMethod() {
        int a = 5;
        int b = 10;
        int sum = a + b;
        // This method does very little work.
    }

    // This method is intentionally slow
    public static void slowMethod() {
        try {
            // This will make the method take 100ms each time it's called.
            Thread.sleep(100); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Profiler demo is running. Attach a profiler now...");
        
        // This loop will run forever so the program doesn't exit.
        while (true) {
            fastMethod();
            slowMethod();
        }
    }
}