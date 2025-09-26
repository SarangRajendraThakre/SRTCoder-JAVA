package ExceptionInJava;


public class P133_ThrowableMethodGetMessage {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            // This throws an exception if no command-line arguments are given.
            System.out.println(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catch");
            // e.getMessage() returns a description of the error.
            System.out.println(e.getMessage());
        }
    }
}