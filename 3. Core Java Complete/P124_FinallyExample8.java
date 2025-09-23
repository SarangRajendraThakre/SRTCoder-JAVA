
public class P124_FinallyExample8 {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            System.out.println("\n--- Iteration " + i + " ---");
            try {
                System.out.println("try block");
                if (i == 2) {
                    // This will throw an exception only when i is 2
                    System.out.println(10 / 0);
                }
                System.out.println("try block finished successfully");
                
            } catch (ArithmeticException ae) {
                System.out.println("catch block: An error occurred!");
                // 'continue' will skip the rest of the loop's current iteration
                // and proceed to the next one (i=3).
                continue; 
            } finally {
                // This will run in every iteration, regardless of exceptions.
                System.out.println("finally block");
            }

            // This line is only reached if no exception occurs or is caught with 'continue'.
            System.out.println("End of loop body for iteration " + i);
        }
    }
}