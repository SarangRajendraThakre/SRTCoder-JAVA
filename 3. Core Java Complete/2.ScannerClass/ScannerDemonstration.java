package scannerclass;

import java.util.InputMismatchException; // For handling type mismatches
import java.util.Scanner;             // For using the Scanner class
import java.util.InputMismatchException; // For handling type mismatches
import java.util.Scanner;             // For using the Scanner class
import java.util.regex.Pattern;       // For explicitly using Pattern objects (optional, but good for regex)

public class ScannerDemonstration {

    public static void main(String[] args) {
        System.out.println("--- Scanner Class Demonstration ---");

        // 1. Basic Input Demonstration
        demonstrateBasicInput();

        // 2. Demonstrating the nextX() vs. nextLine() Trap
        demonstrateNewlineTrap();

        // 3. Demonstrating Input Validation and Error Handling
        demonstrateInputValidation();

        // 4. Demonstrating try-with-resources for resource management
        demonstrateTryWithResources();

        // 5. Demonstrating Regular Expression Features of Scanner
        demonstrateRegexFeatures();

        System.out.println("\n--- End of Scanner Demonstration ---");
    }

    /**
     * Demonstrates basic reading of different data types from console.
     */
    public static void demonstrateBasicInput() {
        System.out.println("\n--- Section 1: Basic Input ---");
        // Using try-with-resources for proper resource management
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your first name (String): ");
            String firstName = scanner.next(); // Reads a single token (word)

            System.out.print("Enter your age (int): ");
            int age = scanner.nextInt(); // Reads an integer

            System.out.print("Enter your height in meters (double): ");
            double height = scanner.nextDouble(); // Reads a double

            // *** IMPORTANT ***: Consume the leftover newline character
            // after nextInt() and nextDouble() if you plan to use nextLine() next.
            // In this specific method, we don't use nextLine() immediately after,
            // but it's crucial for the next scenario. For now, let's just show the output.
            scanner.nextLine(); // Consumes the leftover newline from previous nextDouble()/nextInt()

            System.out.println("\n--- Basic Input Results ---");
            System.out.println("First Name: " + firstName);
            System.out.println("Age: " + age);
            System.out.println("Height: " + height + "m");
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input type in basic input section. Please restart.");
        }
    }

    /**
     * Demonstrates the common nextX() vs. nextLine() trap and its solution.
     */
    public static void demonstrateNewlineTrap() {
        System.out.println("\n--- Section 2: The Newline Trap ---");
        System.out.println("--- (Expected Output: Name will be empty if not handled correctly) ---");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number (e.g., 42): ");
            int number = scanner.nextInt(); // Reads number, leaves '\n'

            System.out.print("Now, enter a full line of text (e.g., This is a test): ");
            // If scanner.nextLine() is called directly here, it will consume the leftover '\n'
            // from nextInt() and appear to skip the line.

            // THE TRAP: (Uncomment to see it happen)
            // String skippedLine = scanner.nextLine();
            // System.out.println("You might see this as empty: '" + skippedLine + "'");

            // THE SOLUTION: Consume the leftover newline
            scanner.nextLine(); // This consumes the '\n' left by nextInt()

            String fullLine = scanner.nextLine(); // Now this reads the actual line of text

            System.out.println("\n--- Newline Trap Results ---");
            System.out.println("Number entered: " + number);
            System.out.println("Full line entered: '" + fullLine + "'");
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input for number. Please restart.");
        }
    }

    /**
     * Demonstrates how to validate user input using hasNextX() and loops.
     */
    public static void demonstrateInputValidation() {
        System.out.println("\n--- Section 3: Input Validation and Error Handling ---");
        // For System.in, it's fine to have one global scanner or pass it around.
        // For demonstration, we create a new one for clarity in each section.
        Scanner scanner = new Scanner(System.in);

        int positiveNumber = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Please enter a positive integer: ");
            if (scanner.hasNextInt()) { // Checks if the next token is an integer
                positiveNumber = scanner.nextInt();
                if (positiveNumber > 0) {
                    isValid = true; // Input is valid
                } else {
                    System.out.println("Invalid input: Number must be positive. Try again.");
                }
            } else {
                // If it's not an int, print error and consume the invalid token
                System.out.println("Invalid input: That's not an integer. Try again.");
            }
            scanner.nextLine(); // Always consume the rest of the line (including newline)
                                // whether input was valid or not, to clear buffer for next read.
        }
        System.out.println("Valid positive number entered: " + positiveNumber);

        // Close the scanner for this specific use case.
        scanner.close();
    }

    /**
     * Demonstrates the best practice of using try-with-resources for Scanner.
     */
    public static void demonstrateTryWithResources() {
        System.out.println("\n--- Section 4: Resource Management with try-with-resources ---");

        // The Scanner object is declared inside the try-with-resources statement.
        // It will be automatically closed when the try block exits,
        // whether normally or due to an exception.
        try (Scanner autoClosingScanner = new Scanner(System.in)) {
            System.out.print("Enter your favorite color: ");
            String color = autoClosingScanner.nextLine();
            System.out.println("Your favorite color is: " + color);
        } // autoClosingScanner.close() is called implicitly here
        catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
        System.out.println("Scanner resource automatically closed.");
    }

    /**
     * Demonstrates various ways Scanner uses Regular Expressions.
     */
    public static void demonstrateRegexFeatures() {
        System.out.println("\n--- Section 5: Regular Expression Features ---");

        // --- 5.1 Custom Delimiter (useDelimiter) ---
        System.out.println("\n--- 5.1 Custom Delimiter ---");
        String data = "apple,banana;cherry|date:2025-07-06";
        try (Scanner delimiterScanner = new Scanner(data)) {
            // Set delimiter to any of: comma, semicolon, pipe, or colon
            delimiterScanner.useDelimiter("[,;|:]"); // This is a regex!

            System.out.println("Original data: \"" + data + "\"");
            System.out.println("Tokens using delimiter \"[,;|:]\":");
            while (delimiterScanner.hasNext()) {
                System.out.println("  - " + delimiterScanner.next());
            }
        }

        // --- 5.2 Reading Tokens Matching a Pattern (next(String regex)) ---
        System.out.println("\n--- 5.2 Reading Specific Patterns (next(String regex)) ---");
        String mixedInput = "Product ID: P12345, Price: 49.99, Code: ABC, Quantity: 100";
        try (Scanner patternScanner = new Scanner(mixedInput)) {
            System.out.println("Original data: \"" + mixedInput + "\"");
            System.out.println("Reading only numbers (\\d+) and Product IDs (P\\d+):");

            // Use hasNext() with regex to find specific tokens
            // This will consume the delimiter after the match
            while (patternScanner.hasNext()) {
                if (patternScanner.hasNext("P\\d+")) { // Pattern for Product ID like P12345
                    System.out.println("  - Product ID found: " + patternScanner.next("P\\d+"));
                } else if (patternScanner.hasNext("\\d+")) { // Pattern for one or more digits
                    System.out.println("  - Number found: " + patternScanner.next("\\d+"));
                } else {
                    // Consume non-matching tokens to avoid infinite loop
                    patternScanner.next();
                }
            }
        }

        // --- 5.3 Finding Patterns within a Line (findInLine(String regex)) ---
        System.out.println("\n--- 5.3 Finding Patterns within a Line (findInLine(String regex)) ---");
        String logEntry = "Log entry: User login at 2025-07-06 10:30:15 from IP 192.168.1.100. Status: SUCCESS";
        try (Scanner findScanner = new Scanner(logEntry)) {
            System.out.println("Original log entry: \"" + logEntry + "\"");

            // Find an IP address pattern (e.g., xxx.xxx.xxx.xxx)
            String ipAddressPattern = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
            String foundIp = findScanner.findInLine(ipAddressPattern);
            if (foundIp != null) {
                System.out.println("  - Found IP Address: " + foundIp);
            } else {
                System.out.println("  - No IP address found.");
            }

            // Find a date pattern (YYYY-MM-DD)
            String datePattern = "\\d{4}-\\d{2}-\\d{2}";
            String foundDate = findScanner.findInLine(datePattern); // findInLine doesn't consume previous matches for next call
            if (foundDate != null) {
                System.out.println("  - Found Date: " + foundDate);
            } else {
                System.out.println("  - No Date found.");
            }

            // You can reset the scanner to search from the beginning again if needed
            // findScanner.reset();
            // String anotherDate = findScanner.findInLine(datePattern);
            // System.out.println("  - Found Date (after reset): " + anotherDate);

        }
        System.out.println("Note: findInLine does not consume input, so it searches from current position.");
    }

}