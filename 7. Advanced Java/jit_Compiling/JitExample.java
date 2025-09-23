


public class JitExample {

    // A method that will be called many times to become a "hot spot"
    public static long calculateSum(int iterations) {
        long sum = 0;
        for (int i = 0; i < iterations; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Starting JIT Example...");

        // Call a method a few times initially (interpreter might run)
        for (int i = 0; i < 5; i++) {
            long result = calculateSum(100);
            System.out.println("Initial sum (100 iterations): " + result);
        }

        System.out.println("\nNow calling a method many times to trigger JIT compilation...");

        // Call the method a large number of times to make it a "hot spot"
        // This is where you'll see JIT compilation messages
        for (int i = 0; i < 50000; i++) { // Increased iterations to ensure compilation
            long result = calculateSum(1000); // More work inside the loop
            if (i % 5000 == 0) { // Print less frequently to avoid excessive output
                 System.out.println("Current iteration: " + i + ", Sum: " + result);
            }
        }

        System.out.println("\nJIT Example Finished.");
    }
}