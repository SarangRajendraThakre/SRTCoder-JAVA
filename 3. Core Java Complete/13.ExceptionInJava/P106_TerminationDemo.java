
public class P106_TerminationDemo {

    public static void main(String[] args) {

        // --- Scenario 1: Normal Termination (Handled Exception) ---
        // The program catches the error and continues to a clean finish.
        System.out.println("--- Demonstrating Normal Termination ---");
        try {
            // This line will cause an error
            System.out.println("Attempting to divide by zero...");
            int result = 10 / 0; 
            System.out.println("This line will never be reached.");
        } catch (ArithmeticException e) {
            // The error is caught here, and this block is executed instead.
            System.out.println("Caught the exception! Program can now finish normally.");
            System.out.println("System's error message was: " + e.getMessage());
        }

        System.out.println("\nProgram has finished its run smoothly.");
        System.out.println("----------------------------------------\n");


        // --- Scenario 2: Abnormal Termination (Unhandled Exception) ---
        // Uncomment the line below to see the program crash.
        // The error is NOT handled, so the program will stop immediately.
        
        System.out.println("--- Demonstrating Abnormal Termination ---");
        System.out.println("The next line will cause the program to crash...");
        
        int crashResult = 10 / 0; // This will throw an unhandled exception

        // This line will never be reached because the program crashes above.
        System.out.println("This final line will never appear.");
    }
}