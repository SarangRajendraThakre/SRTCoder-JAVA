
public class LogicalOperatorsExample {

    public static void main(String[] args) {
        System.out.println("--- Java Logical Operators Examples ---");

        System.out.println("\n--- 1. Logical AND (&&) ---");
        demonstrateLogicalAND();

        System.out.println("\n--- 2. Logical OR (||) ---");
        demonstrateLogicalOR();

        System.out.println("\n--- 3. Logical NOT (!) ---");
        demonstrateLogicalNOT();

        System.out.println("\n--- 4. Short-Circuiting Behavior ---");
        demonstrateShortCircuiting();

        System.out.println("\n--- 5. Operator Precedence with Logical Operators ---");
        demonstratePrecedence();
    }

    /**
     * Demonstrates the Logical AND (&&) operator.
     * Returns true if BOTH operands are true.
     */
    public static void demonstrateLogicalAND() {
        boolean condition1 = true;
        boolean condition2 = false;
        int age = 25;
        int requiredAge = 18;
        boolean hasLicense = true;

        System.out.println("Condition 1: " + condition1);
        System.out.println("Condition 2: " + condition2);
        System.out.println("age >= requiredAge: " + (age >= requiredAge));
        System.out.println("hasLicense: " + hasLicense);

        // true && true -> true
        boolean result1 = (age >= requiredAge && hasLicense);
        System.out.println("(age >= requiredAge && hasLicense) : " + result1); // Expected: true

        // true && false -> false
        boolean result2 = (condition1 && condition2);
        System.out.println("(condition1 && condition2) : " + result2); // Expected: false

        // false && true -> false
        boolean result3 = (condition2 && condition1);
        System.out.println("(condition2 && condition1) : " + result3); // Expected: false

        // false && false -> false
        boolean result4 = (condition2 && false);
        System.out.println("(condition2 && false) : " + result4); // Expected: false
    }

    /**
     * Demonstrates the Logical OR (||) operator.
     * Returns true if AT LEAST ONE of the operands is true.
     */
    public static void demonstrateLogicalOR() {
        boolean isAdmin = false;
        boolean isEditor = true;
        String userRole = "guest";

        System.out.println("isAdmin: " + isAdmin);
        System.out.println("isEditor: " + isEditor);
        System.out.println("userRole.equals(\"admin\"): " + userRole.equals("admin"));
        System.out.println("userRole.equals(\"guest\"): " + userRole.equals("guest"));

        // false || true -> true
        boolean result1 = (isAdmin || isEditor);
        System.out.println("(isAdmin || isEditor) : " + result1); // Expected: true

        // false || false -> false
        boolean result2 = (userRole.equals("admin") || isAdmin);
        System.out.println("(userRole.equals(\"admin\") || isAdmin) : " + result2); // Expected: false

        // true || false -> true
        boolean result3 = (userRole.equals("guest") || isEditor);
        System.out.println("(userRole.equals(\"guest\") || isEditor) : " + result3); // Expected: true
    }

    /**
     * Demonstrates the Logical NOT (!) operator.
     * Inverts the boolean value of its operand.
     */
    public static void demonstrateLogicalNOT() {
        boolean isLoggedIn = false;
        boolean hasPermission = true;

        System.out.println("isLoggedIn: " + isLoggedIn);
        System.out.println("hasPermission: " + hasPermission);

        // !false -> true
        System.out.println("!isLoggedIn : " + !isLoggedIn); // Expected: true

        // !true -> false
        System.out.println("!hasPermission : " + !hasPermission); // Expected: false
    }

    /**
     * Demonstrates the short-circuiting behavior of && and ||.
     * Methods with side effects (like printing) help observe this.
     */
    public static void demonstrateShortCircuiting() {
        System.out.println("\n--- Short-Circuiting with && ---");
        // If testCondition1() is false, testCondition2() will NOT be called.
        if (testCondition1(false) && testCondition2(true)) {
            System.out.println("Both conditions were true (&&).");
        } else {
            System.out.println("One or both conditions were false (&&).");
        }
        // Expected output: "testCondition1 called with false" followed by "One or both conditions were false (&&)."

        System.out.println("\n--- Short-Circuiting with || ---");
        // If testCondition1() is true, testCondition2() will NOT be called.
        if (testCondition1(true) || testCondition2(false)) {
            System.out.println("One or both conditions were true (||).");
        } else {
            System.out.println("Both conditions were false (||).");
        }
        // Expected output: "testCondition1 called with true" followed by "One or both conditions were true (||)."
    }

    // Helper methods to observe short-circuiting
    public static boolean testCondition1(boolean value) {
        System.out.println("  testCondition1 called with " + value);
        return value;
    }

    public static boolean testCondition2(boolean value) {
        System.out.println("  testCondition2 called with " + value);
        return value;
    }

    /**
     * Demonstrates operator precedence involving logical operators.
     * Order: ! > relational (> >= < <= == !=) > && > ||
     */
    public static void demonstratePrecedence() {
        int x = 10;
        int y = 5;
        int z = 12;
        boolean isMember = false;

        System.out.println("x=" + x + ", y=" + y + ", z=" + z + ", isMember=" + isMember);

        // Example 1: ! and &&
        // !isMember && x > y
        // (true && true) -> true
        boolean result1 = !isMember && x > y;
        System.out.println("!isMember && x > y : " + result1); // Expected: true

        // Example 2: relational, &&, ||
        // x > y && z < x || !isMember
        // (10 > 5) && (12 < 10) || (!false)
        // true && false || true
        // false || true
        // true
        boolean result2 = x > y && z < x || !isMember;
        System.out.println("x > y && z < x || !isMember : " + result2); // Expected: true

        // Example 3: Using parentheses to override precedence
        // x > y && (z < x || !isMember)
        // true && (false || true)
        // true && true
        // true
        boolean result3 = x > y && (z < x || !isMember);
        System.out.println("x > y && (z < x || !isMember) : " + result3); // Expected: true

        // Example 4: Different grouping with parentheses
        // (x > y && z < x) || !isMember
        // (true && false) || true
        // false || true
        // true
        boolean result4 = (x > y && z < x) || !isMember;
        System.out.println("(x > y && z < x) || !isMember : " + result4); // Expected: true
    }
}