import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class ScannerDemo {
    public static void main(String[] args) {
        demoFromString();
        demoFromConsole();
        demoFromFile();
        demoFromPath();
    }

    // Scanner from String
    private static void demoFromString() {
        System.out.println("=== Scanner from String ===");
        String text = "Java 100 20.5 true";
        Scanner sc = new Scanner(text);

        System.out.println("Next token: " + sc.next());        // Java
        System.out.println("Next int: " + sc.nextInt());       // 100
        System.out.println("Next double: " + sc.nextDouble()); // 20.5
        System.out.println("Next boolean: " + sc.nextBoolean());// true

        sc.close();
    }

    // Scanner from System.in (console)
    private static void demoFromConsole() {
        System.out.println("\n=== Scanner from Console ===");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        System.out.println("You entered: " + str + " and " + num);

        sc.close();
    }

    // Scanner from File
    private static void demoFromFile() {
        System.out.println("\n=== Scanner from File ===");
        try {
            File file = new File("example.txt"); // create a text file with some content
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

            sc.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // Scanner from Path
    private static void demoFromPath() {
        System.out.println("\n=== Scanner from Path ===");
        try {
            Path path = Paths.get("example.txt"); // same file as above
            Scanner sc = new Scanner(path);

            // Using delimiter
            sc.useDelimiter(" "); // split by space
            while (sc.hasNext()) {
                System.out.println("Token: " + sc.next());
            }

            // Demonstrating match()
            sc = new Scanner("apple banana cherry");
            sc.findInLine("banana");
            MatchResult result = sc.match();
            System.out.println("Matched word: " + result.group() +
                    " (start: " + result.start() + ", end: " + result.end() + ")");

            sc.close();
        } catch (IOException e) {
            System.out.println("Path error: " + e.getMessage());
        }
    }
}
