
import java.util.Scanner;
import java.util.regex.Pattern; // Needed for Pattern object

public class P_5_Scanner_HasNextMethodsDemonstration {

    public static void main(String[] args) {
        System.out.println("--- Scanner hasNextX() Methods Demonstration ---");

        demonstrateHasNextPrimitives();
        demonstrateHasNextLine();
        demonstrateHasNextPatterns();

        System.out.println("\n--- End of Demonstration ---");
    }

    /**
     * Demonstrates hasNext(), hasNextBoolean(), hasNextByte(), hasNextShort(),
     * hasNextInt(), hasNextLong(), hasNextFloat(), hasNextDouble().
     */
    public static void demonstrateHasNextPrimitives() {
        System.out.println("\n--- 1. hasNextX() for Primitive Types ---");

        // --- hasNext() ---
        try (Scanner s = new Scanner("Hello 123")) {
            System.out.println("\n--- hasNext() ---");
            System.out.println("Input: \"Hello 123\"");
            System.out.println("  hasNext(): " + s.hasNext()); // true
            System.out.println("  Next token: " + s.next());    // Consumes "Hello"
            System.out.println("  hasNext(): " + s.hasNext()); // true
            System.out.println("  Next token: " + s.next());    // Consumes "123"
            System.out.println("  hasNext(): " + s.hasNext()); // false (no more tokens)
        }

        // --- hasNextBoolean() ---
        try (Scanner s = new Scanner("true FALSE not_a_boolean")) {
            System.out.println("\n--- hasNextBoolean() ---");
            System.out.println("Input: \"true FALSE not_a_boolean\"");
            System.out.println("  hasNextBoolean(): " + s.hasNextBoolean()); // true
            System.out.println("  Next boolean: " + s.nextBoolean());       // Consumes "true"
            System.out.println("  hasNextBoolean(): " + s.hasNextBoolean()); // true
            System.out.println("  Next boolean: " + s.nextBoolean());       // Consumes "FALSE"
            System.out.println("  hasNextBoolean(): " + s.hasNextBoolean()); // false
            System.out.println("  Remaining: " + s.next());                 // Consumes "not_a_boolean"
        }

        // --- hasNextByte(), hasNextShort(), hasNextInt(), hasNextLong() ---
        try (Scanner s = new Scanner("127 32767 2147483647 9223372036854775807 200 non_num")) {
            System.out.println("\n--- hasNextByte(), hasNextShort(), hasNextInt(), hasNextLong() ---");
            System.out.println("Input: \"127 32767 2147483647 9223372036854775807 200 non_num\"");

            System.out.println("  hasNextByte(): " + s.hasNextByte());   // true
            System.out.println("  Next byte: " + s.nextByte());         // Consumes "127" (max byte value)

            System.out.println("  hasNextShort(): " + s.hasNextShort()); // true
            System.out.println("  Next short: " + s.nextShort());       // Consumes "32767" (max short value)

            System.out.println("  hasNextInt(): " + s.hasNextInt());   // true
            System.out.println("  Next int: " + s.nextInt());           // Consumes "2147483647" (max int value)

            System.out.println("  hasNextLong(): " + s.hasNextLong());   // true
            System.out.println("  Next long: " + s.nextLong());         // Consumes "9223372036854775807" (max long value)

            System.out.println("  hasNextByte() for 200: " + s.hasNextByte()); // false (200 is too large for byte)
            System.out.println("  Next int (the 200): " + s.nextInt());       // Consumes "200" as int

            System.out.println("  hasNextInt() for non_num: " + s.hasNextInt()); // false
            System.out.println("  Remaining: " + s.next());                     // Consumes "non_num"
        }

        // --- hasNextFloat(), hasNextDouble() ---
        try (Scanner s = new Scanner("3.14 1.23456789e-5 not_a_float")) {
            System.out.println("\n--- hasNextFloat(), hasNextDouble() ---");
            System.out.println("Input: \"3.14 1.23456789e-5 not_a_float\"");

            System.out.println("  hasNextFloat(): " + s.hasNextFloat());  // true
            System.out.println("  Next float: " + s.nextFloat());        // Consumes "3.14"

            System.out.println("  hasNextDouble(): " + s.hasNextDouble()); // true
            System.out.println("  Next double: " + s.nextDouble());       // Consumes "1.23456789e-5"

            System.out.println("  hasNextFloat(): " + s.hasNextFloat()); // false
            System.out.println("  hasNextDouble(): " + s.hasNextDouble()); // false
            System.out.println("  Remaining: " + s.next());                 // Consumes "not_a_float"
        }
    }

    /**
     * Demonstrates hasNextLine().
     */
    public static void demonstrateHasNextLine() {
        System.out.println("\n--- 2. hasNextLine() ---");

        // Multi-line string input
        String multiLineInput = "First line\nSecond line\n"; // Note the trailing newline
        try (Scanner s = new Scanner(multiLineInput)) {
            System.out.println("Input: \"" + multiLineInput.replace("\n", "\\n") + "\"");

            System.out.println("  hasNextLine(): " + s.hasNextLine()); // true
            System.out.println("  Next line: \"" + s.nextLine() + "\""); // Consumes "First line\n"

            System.out.println("  hasNextLine(): " + s.hasNextLine()); // true
            System.out.println("  Next line: \"" + s.nextLine() + "\""); // Consumes "Second line\n"

            System.out.println("  hasNextLine(): " + s.hasNextLine()); // false (no more lines)
            System.out.println("  (Note: hasNextLine() checks for a line separator, then input before it.)");
        }

        // Input with no trailing newline
        String noTrailingNewline = "Single line no newline";
        try (Scanner s = new Scanner(noTrailingNewline)) {
            System.out.println("\nInput: \"" + noTrailingNewline + "\"");
            System.out.println("  hasNextLine(): " + s.hasNextLine()); // true
            System.out.println("  Next line: \"" + s.nextLine() + "\""); // Consumes "Single line no newline"
            System.out.println("  hasNextLine(): " + s.hasNextLine()); // false
        }
    }

    /**
     * Demonstrates hasNext(String pattern) and hasNext(Pattern pattern).
     */
    public static void demonstrateHasNextPatterns() {
        System.out.println("\n--- 3. hasNext(String pattern) & hasNext(Pattern pattern) ---");

        String mixedData = "Order123 Apple 45.67 Date:2025-07-06 END";
        try (Scanner s = new Scanner(mixedData)) {
            System.out.println("Input: \"" + mixedData + "\"");

            // --- hasNext(String pattern) ---
            String orderIdPattern = "Order\\d+"; // Matches "Order" followed by one or more digits
            System.out.println("\n  Checking for pattern: \"" + orderIdPattern + "\"");
            System.out.println("  hasNext(\"Order\\\\d+\"): " + s.hasNext(orderIdPattern)); // true
            System.out.println("  Next token (matching): " + s.next(orderIdPattern)); // Consumes "Order123"

            // --- hasNext(Pattern pattern) ---
            Pattern datePattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}"); // Matches YYYY-MM-DD
            System.out.println("\n  Checking for pattern: \"" + datePattern + "\"");
            // Skip "Apple" and "45.67"
            System.out.println("  Skipping: " + s.next()); // Consumes "Apple"
            System.out.println("  Skipping: " + s.next()); // Consumes "45.67"

            // Now next token is "Date:2025-07-06". We check if *its sub-part* matches.
            // No, hasNext(Pattern) checks the *entire* next token against the pattern.
            // "Date:2025-07-06" does not match "\d{4}-\d{2}-\d{2}".
            System.out.println("  hasNext(datePattern): " + s.hasNext(datePattern)); // false (token is "Date:2025-07-06")

            // To match "2025-07-06" we either need a new token, or use findInLine()
            // Let's re-tokenize to get the date part as a separate token
            try (Scanner s2 = new Scanner("Date:2025-07-06")) {
                s2.useDelimiter(":"); // Set delimiter to colon
                s2.next(); // Consume "Date"
                System.out.println("  hasNext(datePattern) after re-tokenizing: " + s2.hasNext(datePattern)); // true
                System.out.println("  Next token (matching): " + s2.next(datePattern)); // Consumes "2025-07-06"
            }
        }
    }
}