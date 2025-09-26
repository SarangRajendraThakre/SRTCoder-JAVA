package scannerclass;

import java.util.Scanner; // Don't forget this!
import java.io.File;
import java.io.FileNotFoundException;

public class ScannerInterviewExample {

    public static void main(String[] args) {
        System.out.println("--- Demonstrating Scanner Usage ---");

        // --- 1. Reading from console (most common) ---
        // Using try-with-resources for automatic closing of the scanner
        try (Scanner consoleScanner = new Scanner(System.in)) {
            System.out.println("\n--- Reading from Console ---");
            System.out.print("Please enter your name: ");
            String name = consoleScanner.nextLine(); // Reads the whole line

            System.out.print("Please enter your favorite number: ");
            int favNumber = consoleScanner.nextInt(); // Reads the integer
            consoleScanner.nextLine(); // Consume the leftover newline after nextInt()

            System.out.println("Hello, " + name + "!");
            System.out.println("Your favorite number is: " + favNumber);

        } catch (Exception e) {
            System.err.println("An error occurred with console input: " + e.getMessage());
        }

        // --- 2. Reading from a String ---
        System.out.println("\n--- Reading from a String ---");
        // Using try-with-resources for automatic closing of the scanner
        try (Scanner stringScanner = new Scanner("Hello 123 world 45.67")) {
            String word1 = stringScanner.next(); // Reads "Hello"
            int num1 = stringScanner.nextInt();   // Reads "123"
            String word2 = stringScanner.next(); // Reads "world"
            double num2 = stringScanner.nextDouble(); // Reads "45.67"

            System.out.println("From stringScanner:");
            System.out.println("Word 1: " + word1);
            System.out.println("Number 1: " + num1);
            System.out.println("Word 2: " + word2);
            System.out.println("Number 2: " + num2);

            // You can also check if there's more input
            if (stringScanner.hasNext()) {
                System.out.println("Remaining input: " + stringScanner.nextLine());
            } else {
                System.out.println("No more input in stringScanner.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred with string input: " + e.getMessage());
        }


        // --- 3. Reading from a File (Uncomment to test) ---
        // To run this, you need a file named 'input.txt' in the same directory
        // as your compiled .class file.
        // Example 'input.txt' content:
        // Line one
        // 123 4.56
        System.out.println("\n--- Reading from a File (requires input.txt) ---");
        Scanner fileScanner = null; // Declare outside try block for finally access
        try {
            fileScanner = new Scanner(new File("C:\\Users\\saran\\Desktop\\java\\m38\\scannerclass\\input.txt"));
            System.out.println("Reading from input.txt:");

            if (fileScanner.hasNextLine()) {
                System.out.println("First line: " + fileScanner.nextLine());
            }
            if (fileScanner.hasNextInt()) {
                int fileNum = fileScanner.nextInt();
                System.out.println("Next int: " + fileNum);
            }
            if (fileScanner.hasNextDouble()) {
                double fileDouble = fileScanner.nextDouble();
                System.out.println("Next double: " + fileDouble);
            }
            // Add more reads as needed based on your file content
            System.out.println("Finished reading from file.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: 'input.txt' not found! Please create it in the same directory as your .java file.");
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred while reading file: " + e.getMessage());
        } finally {
            // Important: Always close the Scanner when done with it, especially for files.
            // Using a plain try-catch, you need a finally block to ensure closing.
            // For Java 7+, try-with-resources is preferred.
            if (fileScanner != null) {
                fileScanner.close();
                System.out.println("File scanner closed.");
            }
        }

        System.out.println("\n--- End of Demonstration ---");
    }
}