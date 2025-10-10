import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class P_5_ScannerDemonstration {

    public static void main(String[] args) {
        System.out.println("--- Scanner Class Demonstration ---");

        // Create a single Scanner for the whole program
        Scanner scanner = new Scanner(System.in);

        // 1. Basic Input Demonstration
        // demonstrateBasicInput(scanner);

        // 2. Demonstrating the nextX() vs. nextLine() Trap
        demonstrateNewlineTrap(scanner);

        // 3. Demonstrating Input Validation and Error Handling
        demonstrateInputValidation(scanner);

        // 4. Demonstrating try-with-resources for resource management
        demonstrateTryWithResources();

        // 5. Demonstrating Regular Expression Features of Scanner
        demonstrateRegexFeatures();

        System.out.println("\n--- End of Scanner Demonstration ---");

        // Close the single Scanner at the very end
        scanner.close();
    }

    public static void demonstrateBasicInput(Scanner scanner) {
        System.out.println("\n--- Section 1: Basic Input ---");
        try {
            System.out.print("Enter your first name (String): ");
            String firstName = scanner.next(); // Reads a single token

            System.out.print("Enter your age (int): ");
            int age = scanner.nextInt();

            System.out.print("Enter your height in meters (double): ");
            double height = scanner.nextDouble();

            scanner.nextLine(); // Consume leftover newline

            System.out.println("\n--- Basic Input Results ---");
            System.out.println("First Name: " + firstName);
            System.out.println("Age: " + age);
            System.out.println("Height: " + height + "m");
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input type. Please restart.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public static void demonstrateNewlineTrap(Scanner scanner) {
        System.out.println("\n--- Section 2: The Newline Trap ---");

        try {
            System.out.print("Enter a number (e.g., 42): ");
            int number = scanner.nextInt();

            scanner.nextLine(); // Consume leftover newline

            System.out.print("Now, enter a full line of text (e.g., This is a test): ");
            String fullLine = scanner.nextLine();

            System.out.println("\n--- Newline Trap Results ---");
            System.out.println("Number entered: " + number);
            System.out.println("Full line entered: '" + fullLine + "'");
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input for number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public static void demonstrateInputValidation(Scanner scanner) {
        System.out.println("\n--- Section 3: Input Validation and Error Handling ---");

        int positiveNumber = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Please enter a positive integer: ");
            if (scanner.hasNextInt()) {
                positiveNumber = scanner.nextInt();
                if (positiveNumber > 0) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input: Number must be positive. Try again.");
                }
            } else {
                System.out.println("Invalid input: That's not an integer. Try again.");
            }
            scanner.nextLine(); // Clear the rest of the line
        }

        System.out.println("Valid positive number entered: " + positiveNumber);
    }

    public static void demonstrateTryWithResources() {
        System.out.println("\n--- Section 4: Resource Management with try-with-resources ---");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your favorite color: ");
            String color = scanner.nextLine();
            System.out.println("Your favorite color is: " + color);
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
        System.out.println("Scanner resource automatically closed.");
    }

    public static void demonstrateRegexFeatures() {
        System.out.println("\n--- Section 5: Regular Expression Features ---");

        // 5.1 Custom Delimiter
        System.out.println("\n--- 5.1 Custom Delimiter ---");
        String data = "apple,banana;cherry|date:2025-07-06";
        try (Scanner delimiterScanner = new Scanner(data)) {
            delimiterScanner.useDelimiter("[,;|:]");
            System.out.println("Tokens using delimiter \"[,;|:]\":");
            while (delimiterScanner.hasNext()) {
                System.out.println("  - " + delimiterScanner.next());
            }
        }

        // 5.2 Reading Tokens Matching a Pattern
        System.out.println("\n--- 5.2 Reading Specific Patterns ---");
        String mixedInput = "Product ID: P12345, Price: 49.99, Code: ABC, Quantity: 100";
        try (Scanner patternScanner = new Scanner(mixedInput)) {
            System.out.println("Reading only numbers (\\d+) and Product IDs (P\\d+):");
            while (patternScanner.hasNext()) {
                if (patternScanner.hasNext("P\\d+")) {
                    System.out.println("  - Product ID found: " + patternScanner.next("P\\d+"));
                } else if (patternScanner.hasNext("\\d+")) {
                    System.out.println("  - Number found: " + patternScanner.next("\\d+"));
                } else {
                    patternScanner.next();
                }
            }
        }

        // 5.3 Finding Patterns within a Line
        System.out.println("\n--- 5.3 Finding Patterns within a Line ---");
        String logEntry = "Log entry: User login at 2025-07-06 10:30:15 from IP 192.168.1.100. Status: SUCCESS";
        try (Scanner findScanner = new Scanner(logEntry)) {
            String ipPattern = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
            String foundIp = findScanner.findInLine(ipPattern);
            System.out.println("  - Found IP Address: " + (foundIp != null ? foundIp : "None"));

            String datePattern = "\\d{4}-\\d{2}-\\d{2}";
            String foundDate = findScanner.findInLine(datePattern);
            System.out.println("  - Found Date: " + (foundDate != null ? foundDate : "None"));
        }

        System.out.println("Note: findInLine does not consume input, so it searches from current position.");
    }
}
