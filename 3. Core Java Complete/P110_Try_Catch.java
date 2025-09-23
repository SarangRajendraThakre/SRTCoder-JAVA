

public class P110_Try_Catch {

    public static void main(String[] args) {
        System.out.println("Hiiii");
        
        // The outer try is not necessary in this specific logic, 
        // but we'll keep it to match the original structure.
        try {
            System.out.println("Outer try");

            // The inner try block, now correctly paired with a catch block.
            try {
                System.out.println("Inner try");
                // This throws an ArithmeticException.
                System.out.println(10 / 0); 
            } catch (ArithmeticException ae) { 
                // This catch block now handles the exception from the inner try.
                System.out.println("Inner catch: Handled the arithmetic error!");
            }
            
        } catch (Exception e) {
            // A general catch for the outer try block.
            System.out.println("Outer catch");
        }
        
        System.out.println("bye");
    }
}