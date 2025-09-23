


public class P107_Try_Catch {

    public static void main(String[] args) {
        System.out.println("Hiiii");

        try {
            System.out.println("try");
            // This line will cause an error if you don't provide command-line arguments.
            // It tries to access the second argument (at index 1).
            System.out.println(args[1]);
            
        }  catch (RuntimeException re) {
            // The more general exception is caught second, as a fallback.
            System.out.println("catch 1: Handled a general runtime error.");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            
            // CORRECTED: The more specific exception is caught first. 🎯
            System.out.println("catch 2: Handled the specific array index error.");

        }

        System.out.println("Bye");
    }
}