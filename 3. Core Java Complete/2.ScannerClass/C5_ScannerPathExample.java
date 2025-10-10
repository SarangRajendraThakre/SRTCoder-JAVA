import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class C5_ScannerPathExample {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("example.txt"); // create Path object
            Scanner sc = new Scanner(path);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

            sc.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
