import java.io.IOException;

public class  P103_ExceptionLogicDemo {

    // --- 1. "Fully Checked" Method ---
    // The parent (Exception) and this child (IOException) are both CHECKED.
    public void fullyCheckedMethod() throws IOException {
        // The compiler sees "throws IOException" and enforces handling.
        throw new IOException("Both parent and child are checked!");
    }

    // --- 2. "Partially Checked" (Unchecked) Method ---
    // The grandparent (Exception) is checked, but the child (ArithmeticException) is UNCHECKED.
    public void partiallyCheckedMethod() {
        // The compiler does NOT check for this. It's a programming error.
        // This will throw an ArithmeticException, which is a type of RuntimeException.
        int result = 10 / 0; 
    }

    public static void main(String[] args) {
        P103_ExceptionLogicDemo demo = new P103_ExceptionLogicDemo();

        System.out.println("--- Demonstrating 'Fully Checked' Exception ---");
        // We MUST use a try-catch block here.
        // If you remove it, the program will NOT compile.
        try {
            demo.fullyCheckedMethod();
        } catch (IOException e) {
            System.out.println("✅ Caught it! The compiler forced us to handle this.");
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Demonstrating 'Partially Checked' (Unchecked) Exception ---");
        // We CAN use a try-catch block, but the compiler does NOT require it.
        // The program compiles fine even without it, but would crash at runtime.
        try {
            demo.partiallyCheckedMethod();
        } catch (ArithmeticException e) {
            System.out.println("✅ Caught it! Handling this was optional but good practice.");
            System.out.println("Error: Cannot divide by zero.");
        }
        
        System.out.println("\nProgram finished successfully.");
    }
}