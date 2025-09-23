package Operator;

public class ArithmeticOperatorsDemo {

    public static void main(String[] args) {

        // --- ADDITION (+) ---
        System.out.println("--- ADDITION (+) ---");
        byte byteAddResult = (byte) (10 + 20); // Result is int, explicit cast to byte for assignment
        System.out.println("byte + byte: 10 + 20 = " + byteAddResult + " (Type: int/byte for assignment)");

        short shortAddResult = (short) (200 + 500); // Result is int
        System.out.println("short + short: 200 + 500 = " + shortAddResult + " (Type: int/short for assignment)");

        char charAddResult = (char) ('a' + 'b'); // Result is int, then cast to char
        System.out.println("char + char: 'a' + 'b' = " + ('a' + 'b') + " (Type: int, char representation: " + charAddResult + ")");

        int intAddResult = 1000 + 3000;
        System.out.println("int + int: 1000 + 3000 = " + intAddResult + " (Type: int)");

        long longAddResult = 1000L + 2000L;
        System.out.println("long + long: 1000L + 2000L = " + longAddResult + " (Type: long)");

        float floatAddResult = 1.1f + 2.2f;
        System.out.println("float + float: 1.1f + 2.2f = " + floatAddResult + " (Type: float)");

        double doubleAddResult = 1.1 + 2.2;
        System.out.println("double + double: 1.1 + 2.2 = " + doubleAddResult + " (Type: double)");

        // boolean + boolean -> Compile-time error (CTE)
        // System.out.println(true + false); // Uncommenting this line will cause a compile-time error

        String stringAddResult = "SRT" + "codes";
        System.out.println("String + String: \"SRT\" + \"codes\" = " + stringAddResult + " (Type: String)");
        System.out.println();


        // --- SUBTRACTION (-) ---
        System.out.println("--- SUBTRACTION (-) ---");
        byte byteSubResult = (byte) (13 - 50); // Result is int
        System.out.println("byte - byte: 13 - 50 = " + byteSubResult + " (Type: int/byte for assignment)");

        short shortSubResult = (short) (32677 - (-32678)); // Result is int
        System.out.println("short - short: 32677 - (-32678) = " + shortSubResult + " (Type: int/short for assignment)");

        char charSubResult = (char) ('A' - 'C'); // Result is int
        System.out.println("char - char: 'A' - 'C' = " + ('A' - 'C') + " (Type: int, char representation: " + charSubResult + ")");

        long intToLongSubResult = 2147483647L - (-2147483648L); // One operand is long, so result is long
        System.out.println("int - int (long promotion): 2147483647 - (-2147483648) = " + intToLongSubResult + " (Type: long)");

        long longSubResult = 10000L - 3000L;
        System.out.println("long - long: 10000L - 3000L = " + longSubResult + " (Type: long)");

        float floatSubResult = 1.1f - 0.1f;
        System.out.println("float - float: 1.1f - 0.1f = " + floatSubResult + " (Type: float)");

        double doubleSubResult = 1.1 - 0.1;
        System.out.println("double - double: 1.1 - 0.1 = " + doubleSubResult + " (Type: double)");

        // boolean - boolean -> Compile-time error (CTE)
        // System.out.println(true - false);

        // String - String -> Compile-time error (CTE)
        // System.out.println("SRT" - "codes");
        System.out.println();


        // --- MULTIPLICATION (*) ---
        System.out.println("--- MULTIPLICATION (*) ---");
        byte byteMulResult = (byte) (127 * 2); // Result is int
        System.out.println("byte * byte: 127 * 2 = " + byteMulResult + " (Type: int/byte for assignment)");

        short shortMulResult = (short) (32677 * 10); // Result is int
        System.out.println("short * short: 32677 * 10 = " + shortMulResult + " (Type: int/short for assignment)");

        char charMulResult = (char) ('a' * 'd'); // Result is int
        System.out.println("char * char: 'a' * 'd' = " + ('a' * 'd') + " (Type: int, char representation: " + charMulResult + ")");

        long intMulLongResult = 2147483647L * 2; // One operand is long, result is long
        System.out.println("int * long: 2147483647 * 2 = " + intMulLongResult + " (Type: long)");

        long longMulResult = 1000L * 2L;
        System.out.println("long * long: 1000L * 2L = " + longMulResult + " (Type: long)");

        float floatMulResult = 1.1f * 2.0f;
        System.out.println("float * float: 1.1f * 2.0f = " + floatMulResult + " (Type: float)");

        double doubleMulResult = 1.1 * 2.0;
        System.out.println("double * double: 1.1 * 2.0 = " + doubleMulResult + " (Type: double)");

        // boolean * boolean -> Compile-time error (CTE)
        // System.out.println(true * false);

        // String * String -> Compile-time error (CTE)
        // System.out.println("SRT" * "codes");
        System.out.println();


        // --- DIVISION (/) ---
        System.out.println("--- DIVISION (/) ---");
        byte byteDivResult = (byte) (10 / 2); // Result is int
        System.out.println("byte / byte: 10 / 2 = " + byteDivResult + " (Type: int/byte for assignment)");

        short shortDivResult = (short) (200 / -2); // Result is int
        System.out.println("short / short: 200 / -2 = " + shortDivResult + " (Type: int/short for assignment)");

        char charDivResult = (char) ('B' / 'D'); // Result is int
        System.out.println("char / char: 'B' / 'D' = " + ('B' / 'D') + " (Type: int, char representation: " + charDivResult + ")");

        int intDivResult = 2147483646 / 2;
        System.out.println("int / int: 2147483646 / 2 = " + intDivResult + " (Type: int)");

        long longDivResult = 1000L / 2L;
        System.out.println("long / long: 1000L / 2L = " + longDivResult + " (Type: long)");

        float floatDivResult = 10.0f / 2.0f;
        System.out.println("float / float: 10.0f / 2.0f = " + floatDivResult + " (Type: float)");

        double doubleDivResult = 10.0 / 2.0;
        System.out.println("double / double: 10.0 / 2.0 = " + doubleDivResult + " (Type: double)");

        // boolean / boolean -> Compile-time error (CTE)
        // System.out.println(true / false);

        // String / String -> Compile-time error (CTE)
        // System.out.println("SRT" / "codes");
        System.out.println();


        // --- MODULUS (%) ---
        System.out.println("--- MODULUS (%) ---");
        int byteModResult = 10 % 3; // Result is int
        System.out.println("byte % byte: 10 % 3 = " + byteModResult + " (Type: int)");

        int shortModResult = 200 % 7; // Result is int
        System.out.println("short % short: 200 % 7 = " + shortModResult + " (Type: int)");

        int charModResult = 'B' % 'D'; // Result is int
        System.out.println("char % char: 'B' % 'D' = " + charModResult + " (Type: int)");

        int intModResult = 15 % 4;
        System.out.println("int % int: 15 % 4 = " + intModResult + " (Type: int)");

        long longModResult = 1000L % 3L;
        System.out.println("long % long: 1000L % 3L = " + longModResult + " (Type: long)");

        float floatModResult = 10.0f % 3.0f;
        System.out.println("float % float: 10.0f % 3.0f = " + floatModResult + " (Type: float)");

        double doubleModResult = 10.0 % 3.0;
        System.out.println("double % double: 10.0 % 3.0 = " + doubleModResult + " (Type: double)");

        // boolean % boolean -> Compile-time error (CTE)
        // System.out.println(true % false);

        // String % String -> Compile-time error (CTE)
        // System.out.println("SRT" % "codes");
        System.out.println();

        System.out.println("--- Mixed Type Operations (Examples) ---");
        // Implicit type promotion rules
        int mixedIntLong = 10 + 2000; // int is promoted to long, result is long
        System.out.println("int + int: 10 + 2000 = " + mixedIntLong + " (Type: long)");

        double mixedFloatDouble = 1.1f * 5.0; // float is promoted to double, result is double
        System.out.println("float * double: 1.1f * 5.0 = " + mixedFloatDouble + " (Type: double)");

        int charIntMixed = 'A' + 10; // char is promoted to int, result is int
        System.out.println("char + int: 'A' + 10 = " + charIntMixed + " (Type: int)");

        // Division by zero for integral types will throw ArithmeticException
        // int zeroDivInt = 10 / 0; // Uncommenting this will throw an ArithmeticException at runtime
        // System.out.println("Division by zero (int): " + zeroDivInt);

        // Division by zero for floating point types results in Infinity or NaN
        double zeroDivDouble = 10.0 / 0.0;
        System.out.println("Division by zero (double): 10.0 / 0.0 = " + zeroDivDouble);

        double zeroDivNegativeDouble = -10.0 / 0.0;
        System.out.println("Division by zero (negative double): -10.0 / 0.0 = " + zeroDivNegativeDouble);

        double zeroDivZeroDouble = 0.0 / 0.0;
        System.out.println("Division by zero (0.0 / 0.0): 0.0 / 0.0 = " + zeroDivZeroDouble);
    }
}