package ExceptionInJava;

public class P162_ThrowsExample2 {

    public static void main(String[] args) {
        String name = "Hello Java";

        for (int i = 0; i < name.length(); i++) {
            // Print one character
            System.out.println(name.charAt(i));

            // The risky code is placed inside a try block.
            try {
                // Pause for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                // If an interruption occurs, this block will handle it.
                System.out.println("InterruptedException handled");
            }
        }
    }
}