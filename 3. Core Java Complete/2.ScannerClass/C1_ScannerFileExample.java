import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class C1_ScannerFileExample {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt"); // file in your project folder

            // Scanner(File source)
            // Purpose:
            // Creates a Scanner that reads input from a file instead of the console.

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
