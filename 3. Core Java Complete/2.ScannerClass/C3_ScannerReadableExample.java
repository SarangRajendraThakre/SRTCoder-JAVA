import java.io.StringReader;
import java.util.Scanner;

public class C3_ScannerReadableExample {
    public static void main(String[] args) {
        StringReader sr = new StringReader("Hello World\nJava Scanner");

        // Scanner(Readable source)
        // Purpose:
        // Creates a Scanner that reads input from any object that implements the
        // Readable interface.
        // Readable is a generic interface in Java that represents a source of
        // characters.

        Scanner sc = new Scanner(sr);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        sc.close();
    }
}
