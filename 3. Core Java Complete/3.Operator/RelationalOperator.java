

public class RelationalOperator {

    public static void main(String[] args) {

        System.out.println("--- Basic Numerical Comparisons ---");
        System.out.println("10 > 20: " + (10 > 20));             // Expected: false
        System.out.println("10 < 20: " + (10 < 20));             // Expected: true
        System.out.println("0 < 0.0: " + (0 < 0.0));             // Expected: false (0 is promoted to 0.0 for comparison)
        System.out.println("0 == 0.0: " + (0 == 0.0));             // Expected: false (0 is promoted to 0.0 for comparison)
        System.out.println("59.999 == 60: " + (59.999 == 60));   // Expected: false
        System.out.println("97 != 100: " + (97 != 100));         // Expected: true

        System.out.println("\n--- Character Comparisons (ASCII/Unicode Values) ---");
        System.out.println("'a' < 'A': " + ('a' < 'A'));         // Expected: false (ASCII: 97 < 65 is false)
        System.out.println("'z' <= 122: " + ('z' <= 122));       // Expected: true (ASCII: 122 <= 122 is true)
        // System.out.println("'' < ' ': " + ('' < ' '));           // Expected: true (Empty character literal is not valid. Assuming this was a typo or misunderstanding. If it was intended as char literal, it would be a compile error. If it was to compare ASCII values, it would be char with space. Let's demonstrate empty string vs space)
        // Correction: '' is not a valid char literal. Let's use a different example if char comparison with non-printable characters was intended.
        // For demonstration, let's compare ' ' (space) with 'A'
        System.out.println("' ' < 'A': " + (' ' < 'A'));         // Expected: true (ASCII: 32 < 65 is true)

        System.out.println("\n--- Boolean Comparisons (Special Cases) ---");
        // System.out.println(false < true); // This line causes a Compile-Time Error in Java
                                           // Explanation: Relational operators (<, >, <=, >=) are not applicable to boolean types.
        System.out.println("true != true: " + (true != true));   // Expected: false (No CTE, this is valid boolean comparison)

        System.out.println("\n--- Floating-Point Precision and Type Coercion ---");
        System.out.println("22/7 >= 22.0/7.0: " + (22/7 >= 22.0/7.0));
                                             // Expected: false (3 >= 3.1428...)
        System.out.println("22.0/7.0 > 22.0f/7.0f: " + (22.0/7.0 > 22.0f/7.0f));
        System.out.println("22.0/7.0 == 22.0f/7.0f: " + (22.0/7.0 == 22.0f/7.0f));
                                             // Expected: true (double precision vs float precision)
        System.out.println("22.0 / 7.0 (double): " + (22.0 / 7.0));
                                             // Expected: ~3.142857142857143
        System.out.println("22.0f / 7.0f (float): " + (22.0f / 7.0f));
                                             // Expected: ~3.142857

        System.out.println("\n--- Complicated Relationships / Edge Cases ---");

        // 1. Integer Overflow/Underflow vs. Comparison
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        System.out.println("maxInt + 1 > maxInt: " + (maxInt + 1 > maxInt)); // Expected: false (overflow)
        System.out.println("minInt - 1 < minInt: " + (minInt - 1 < minInt)); // Expected: false (underflow)

        // 2. NaN (Not-a-Number) Comparisons
        double nan = Double.NaN;
        System.out.println("Double.NaN == Double.NaN: " + (nan == nan));           // Expected: false (NaN is never equal to itself)
        System.out.println("Double.NaN > 0: " + (nan > 0));                         // Expected: false
        System.out.println("Double.NaN < 0: " + (nan < 0));                         // Expected: false
        System.out.println("Double.NaN != 0: " + (nan != 0));                       // Expected: true
        System.out.println("Double.isNaN(Double.NaN): " + Double.isNaN(nan));      // Expected: true (Correct way to check for NaN)

        // 3. Floating-point equality with small differences
        double a = 0.1 + 0.2; // This is actually 0.30000000000000004
        double b = 0.3;       // This is exactly 0.3
        System.out.println("0.1 + 0.2 == 0.3: " + (a == b));                     // Expected: false (due to floating point representation)
        System.out.println("Is 0.1 + 0.2 approx 0.3? (tolerance): " + (Math.abs(a - b) < 1e-9)); // Expected: true (better way)

        // 4. String comparison (using == vs. .equals())
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        System.out.println("s1 == s2: " + (s1 == s2));                   // Expected: true (String literal pooling)
        System.out.println("s1 == s3: " + (s1 == s3));                   // Expected: false (different objects in memory)
        System.out.println("s1.equals(s3): " + (s1.equals(s3)));         // Expected: true (compares content)

        // 5. Mixed Type Comparisons (Automatic Type Promotion)
        int intVal = 10;
        long longVal = 10L;
        float floatVal = 10.0f;
        double doubleVal = 10.0;

        System.out.println("intVal == longVal: " + (intVal == longVal));     // int promoted to long
        System.out.println("longVal == floatVal: " + (longVal == floatVal)); // long promoted to float (potential precision loss)
        System.out.println("floatVal == doubleVal: " + (floatVal == doubleVal)); // float promoted to double

        // Example of potential precision loss with float/long
        long bigLong = 987654321034L;
        float bigFloat = 987654321034F; // Will lose precision
        System.out.println("bigLong: " + bigLong);
        System.out.println("bigFloat: " + bigFloat);
        System.out.println("bigLong == bigFloat: " + (bigLong == bigFloat)); // true due to promotion

    }
}