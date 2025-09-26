package ExceptionInJava;


public class P161_ThrowsExample2 {

    // The 'throws' keyword is used here because Thread.sleep() can
    // throw a checked InterruptedException.
    public static void main(String[] args) throws InterruptedException {
    
        String name = "Hello Java";
        
        for (int i = 0; i < name.length(); i++) {
            // Print one character
            System.out.println(name.charAt(i));
            
            // Pause for 1 second
            Thread.sleep(1000);
        }
    }
}