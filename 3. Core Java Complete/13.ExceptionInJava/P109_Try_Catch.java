
import java.io.*;

public class P109_Try_Catch {
    public static void main(String[] args) {
        System.out.println("Hiiii");
        try {
            System.out.println("try");
            // This throws a FileNotFoundException, which is a type of IOException.
            FileReader file = new FileReader("abc.txt");
        } catch (RuntimeException re) {
            // This is skipped because FileNotFoundException is not a RuntimeException.
            System.out.println("catch 1");
        } catch (IOException ie) {
            // This is executed because FileNotFoundException is an IOException.
            System.out.println("catch 2");
        } catch (Exception e) {
            // This is skipped because a handler was already found.
            System.out.println("catch 3");
        }
        System.out.println("Bye");
    }
}