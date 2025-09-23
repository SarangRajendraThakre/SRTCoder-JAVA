package P5_scannerclass;

import java.util.InputMismatchException; // For handling type mismatches
import java.util.NoSuchElementException; // For handling when no more input is available
import java.util.Scanner;
import java.util.regex.Pattern;       // Needed for Pattern object

public class P_5_Scanner_NextMethodsDemonstration {

    public static void main(String[] args) {
        System.out.println("--- Scanner nextX() Methods Demonstration ---");

        demonstrateNextPrimitives();
        demonstrateNextBoolean();
        demonstrateNextLine(); // Special case, often with newline trap
        demonstrateNextPatterns();

        System.out.println("\n--- End of Demonstration ---");
    }

    /**
     * Demonstrates next(), nextByte(), nextShort(), nextInt(), nextLong(), nextFloat(), nextDouble().
     */
    public static void demonstrateNextPrimitives() {
        System.out.println("\n--- 1. nextX() for Primitive Types ---");

        // --- next() (String token) ---
        try (Scanner s = new Scanner("Hello World 123")) {
            System.out.println("\n--- next() ---");
            System.out.println("Input: \"Hello World 123\"");
            System.out.println("  Token 1: \"" + s.next() + "\""); // Reads "Hello"
            System.out.println("  Token 2: \"" + s.next() + "\""); // Reads "World"
            System.out.println("  Token 3: \"" + s.next() + "\""); // Reads "123"
            // Trying to read more will cause NoSuchElementException
            // System.out.println("  Token 4: " + s.next());
        } catch (NoSuchElementException e) {
            System.out.println("  No more tokens (expected).");
        }

        // --- nextByte(), nextShort(), nextInt(), nextLong() ---
        // Input string designed to test boundaries and type mismatches
        String numericInput = "120 32000 2147483647 9223372036854775807 250 (too big for byte) Text";
        try (Scanner s = new Scanner(numericInput)) {
            System.out.println("\n--- nextByte(), nextShort(), nextInt(), nextLong() ---");
            System.out.println("Input: \"" + numericInput + "\"");

            System.out.println("  Next byte: " + s.nextByte());         // Reads "120"
            System.out.println("  Next short: " + s.nextShort());       // Reads "32000"
            System.out.println("  Next int: " + s.nextInt());           // Reads "2147483647"
            System.out.println("  Next long: " + s.nextLong());         // Reads "9223372036854775807"

            // Demonstrate InputMismatchException
            System.out.print("  Attempting to read '250' as a byte (will fail): ");
            try {
                // The current next token is "250". It's too big for a byte.
                System.out.println("  " + s.nextByte());
            } catch (InputMismatchException e) {
                System.out.println("Caught InputMismatchException for byte!");
                s.next(); // Consume the invalid token ("250") to avoid infinite loop
            }

            System.out.print("  Attempting to read 'Text' as an int (will fail): ");
            try {
                System.out.println("  " + s.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Caught InputMismatchException for int!");
                s.next(); // Consume the invalid token ("Text")
            }
        }

        // --- nextFloat(), nextDouble() ---
     String floatDoubleInput = "3.14 1.23456789e-5 not_a_num"; // REMOVED 'F' here
        try (Scanner s = new Scanner(floatDoubleInput)) {
            System.out.println("\n--- nextFloat(), nextDouble() ---");
            System.out.println("Input: \"" + floatDoubleInput + "\"");

            System.out.println("  Next float: " + s.nextFloat());      // Reads "3.14" correctly
            System.out.println("  Next double: " + s.nextDouble());     // Reads "1.23456789e-5" correctly

            System.out.print("  Attempting to read 'not_a_num' as a double (will fail): ");
            try {
                System.out.println("  " + s.nextDouble());
            } catch (InputMismatchException e) {
                System.out.println("Caught InputMismatchException for double!");
                s.next(); // Consume the invalid token
            }
        }
    }

    /**
     * Demonstrates nextBoolean().
     */
    public static void demonstrateNextBoolean() {
        System.out.println("\n--- 2. nextBoolean() ---");
        String booleanInput = "true TRUE False false no Yes";
        try (Scanner s = new Scanner(booleanInput)) {
            System.out.println("Input: \"" + booleanInput + "\"");

            System.out.println("  Next boolean: " + s.nextBoolean()); // true
            System.out.println("  Next boolean: " + s.nextBoolean()); // true (case-insensitive)
            System.out.println("  Next boolean: " + s.nextBoolean()); // false
            System.out.println("  Next boolean: " + s.nextBoolean()); // false

            System.out.print("  Attempting to read 'no' as a boolean (will fail): ");
            try {
                System.out.println("  " + s.nextBoolean());
            } catch (InputMismatchException e) {
                System.out.println("Caught InputMismatchException for boolean!");
                s.next(); // Consume "no"
            }
            System.out.print("  Attempting to read 'Yes' as a boolean (will fail): ");
            try {
                System.out.println("  " + s.nextBoolean());
            } catch (InputMismatchException e) {
                System.out.println("Caught InputMismatchException for boolean!");
                s.next(); // Consume "Yes"
            }
        }
    }

    /**
     * Demonstrates nextLine() and the newline trap when mixed with nextX() methods.
     */
    public static void demonstrateNextLine() {
        System.out.println("\n--- 3. nextLine() (and the Newline Trap) ---");
        System.out.println("Please interact with the console for this section.");

        try (Scanner s = new Scanner(System.in)) { // Use System.in for interactive demo

            System.out.print("  Enter your age (e.g., 30): ");
            int age = s.nextInt(); // Reads 30, leaves '\n' in the buffer

            System.out.print("  Enter your full name (e.g., John Doe): ");
            // If you uncomment the line below, 'fullName' will be empty
            // String problemName = s.nextLine(); // Reads the leftover '\n'
            // System.out.println("  Problematic name (empty): '" + problemName + "'");

            s.nextLine(); // --- SOLUTION: Consume the leftover newline ---

            String fullName = s.nextLine(); // Now correctly reads the full name

            System.out.println("  Age: " + age);
            System.out.println("  Full Name: '" + fullName + "'");
        } catch (InputMismatchException e) {
            System.out.println("  Input Error: Please enter numbers/text as requested.");
        }
    }

    /**
     * Demonstrates next(String pattern) and next(Pattern pattern).
     */
    public static void demonstrateNextPatterns() {
        System.out.println("\n--- 4. next(String pattern) & next(Pattern pattern) ---");

        // --- next(String pattern) ---
        String dataWithCodes = "START ABC-123 DEF-456 END";
        try (Scanner s = new Scanner(dataWithCodes)) {
            System.out.println("\n--- next(String pattern) ---");
            System.out.println("Input: \"" + dataWithCodes + "\"");

            // Consume "START"
            s.next();

            String codePattern = "[A-Z]{3}-\\d{3}"; // Matches e.g., "ABC-123"
            System.out.println("  Looking for pattern: \"" + codePattern + "\"");

            System.out.println("  Found code 1: " + s.next(codePattern)); // Reads "ABC-123"

            // Next token "DEF-456" also matches the pattern
            System.out.println("  Found code 2: " + s.next(codePattern)); // Reads "DEF-456"

            // Next token is "END", which does not match the pattern.
            System.out.print("  Attempting to read 'END' with pattern (will fail): ");
            try {
                System.out.println("  " + s.next(codePattern));
            } catch (InputMismatchException e) {
                System.out.println("Caught InputMismatchException for pattern!");
                s.next(); // Consume "END"
            }
        }

        // --- next(Pattern pattern) ---
        String textWithEmails = "User bob@example.com logged in. Admin john.doe@domain.net finished.";
        try (Scanner s = new Scanner(textWithEmails)) {
            System.out.println("\n--- next(Pattern pattern) ---");
            System.out.println("Input: \"" + textWithEmails + "\"");

            // Define a simple email regex pattern
            Pattern emailPattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");

            // Loop to find all emails
            while (s.hasNext()) { // Keep checking if there are more tokens
                if (s.hasNext(emailPattern)) { // If the next token matches our email pattern
                    System.out.println("  Found email: " + s.next(emailPattern)); // Read the email
                } else {
                    s.next(); // Consume the non-matching token (e.g., "User", "logged", "in")
                }
            }
        }
    }
}


