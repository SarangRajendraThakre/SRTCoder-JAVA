

public class  P116_Finally {
    public static void main(String[] args) {
        System.out.println("DB Connection");
        System.out.println("Hello");
        try {
            System.out.println("try block");
            // This throws an unhandled exception.
            System.out.println(10 / 0);
        } finally {
            // This block is guaranteed to run for cleanup before the program crashes.
            System.out.println("Crucical statements");
            System.out.println("DB Connection close");
        }
    }
}