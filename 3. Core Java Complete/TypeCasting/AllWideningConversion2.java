package TypeCasting;

public class AllWideningConversion2 {

    public static void main(String[] args) {

        System.out.println("--- DEMONSTRATING WIDENING PRIMITIVE CONVERSIONS (ADDITION) ---");
        System.out.println("Rule: Smaller types promote to larger types. byte/short/char promote to int in arithmetic.");
        System.out.println("Note: (+) with String means concatenation. (+) with boolean is Compile Time Error.");

        // Define a set of values for the second operand to test against
        byte op2_byte = 2;
        short op2_short = 50;
        char op2_char = 'Z'; // ASCII 90
        int op2_int = 300;
        long op2_long = 20000L;
        float op2_float = 2.5f;
        double op2_double = 1.25;
        boolean op2_boolean = true;
        String op2_string = " World!";

        System.out.println("\n=============================================");
        System.out.println("1. First Operand is byte");
        System.out.println("=============================================");
        byte op1_byte = 10;
        System.out.println(op1_byte + " (byte) + " + op2_byte + " (byte) = " + (op1_byte + op2_byte) + " (int)");
        System.out.println(op1_byte + " (byte) + " + op2_short + " (short) = " + (op1_byte + op2_short) + " (int)");
        System.out.println(op1_byte + " (byte) + '" + op2_char + "' (char) = " + (op1_byte + op2_char) + " (int)");
        System.out.println(op1_byte + " (byte) + " + op2_int + " (int) = " + (op1_byte + op2_int) + " (int)");
        System.out.println(op1_byte + " (byte) + " + op2_long + " (long) = " + (op1_byte + op2_long) + " (long)");
        System.out.println(op1_byte + " (byte) + " + op2_float + " (float) = " + (op1_byte + op2_float) + " (float)");
        System.out.println(op1_byte + " (byte) + " + op2_double + " (double) = " + (op1_byte + op2_double) + " (double)");
        System.out.println(op1_byte + " (byte) + " + op2_boolean + " (boolean) = Compile Time Error (Cannot add numeric to boolean)");
        System.out.println(op1_byte + " (byte) + \"" + op2_string + "\" (String) = \"" + (op1_byte + op2_string) + "\" (String - Concatenation)");


        System.out.println("\n=============================================");
        System.out.println("2. First Operand is short");
        System.out.println("=============================================");
        short op1_short = 20;
        System.out.println(op1_short + " (short) + " + op2_byte + " (byte) = " + (op1_short + op2_byte) + " (int)");
        System.out.println(op1_short + " (short) + " + op2_short + " (short) = " + (op1_short + op2_short) + " (int)");
        System.out.println(op1_short + " (short) + '" + op2_char + "' (char) = " + (op1_short + op2_char) + " (int)");
        System.out.println(op1_short + " (short) + " + op2_int + " (int) = " + (op1_short + op2_int) + " (int)");
        System.out.println(op1_short + " (short) + " + op2_long + " (long) = " + (op1_short + op2_long) + " (long)");
        System.out.println(op1_short + " (short) + " + op2_float + " (float) = " + (op1_short + op2_float) + " (float)");
        System.out.println(op1_short + " (short) + " + op2_double + " (double) = " + (op1_short + op2_double) + " (double)");
        System.out.println(op1_short + " (short) + " + op2_boolean + " (boolean) = Compile Time Error (Cannot add numeric to boolean)");
        System.out.println(op1_short + " (short) + \"" + op2_string + "\" (String) = \"" + (op1_short + op2_string) + "\" (String - Concatenation)");


        System.out.println("\n=============================================");
        System.out.println("3. First Operand is char");
        System.out.println("=============================================");
        char op1_char = 'A'; // ASCII 65
        System.out.println("'" + op1_char + "' (char) + " + op2_byte + " (byte) = " + (op1_char + op2_byte) + " (int)");
        System.out.println("'" + op1_char + "' (char) + " + op2_short + " (short) = " + (op1_char + op2_short) + " (int)");
        System.out.println("'" + op1_char + "' (char) + '" + op2_char + "' (char) = " + (op1_char + op2_char) + " (int)");
        System.out.println("'" + op1_char + "' (char) + " + op2_int + " (int) = " + (op1_char + op2_int) + " (int)");
        System.out.println("'" + op1_char + "' (char) + " + op2_long + " (long) = " + (op1_char + op2_long) + " (long)");
        System.out.println("'" + op1_char + "' (char) + " + op2_float + " (float) = " + (op1_char + op2_float) + " (float)");
        System.out.println("'" + op1_char + "' (char) + " + op2_double + " (double) = " + (op1_char + op2_double) + " (double)");
        System.out.println("'" + op1_char + "' (char) + " + op2_boolean + " (boolean) = Compile Time Error (Cannot add numeric to boolean)");
        System.out.println("'" + op1_char + "' (char) + \"" + op2_string + "\" (String) = \"" + (op1_char + op2_string) + "\" (String - Concatenation)");


        System.out.println("\n=============================================");
        System.out.println("4. First Operand is int");
        System.out.println("=============================================");
        int op1_int = 100;
        System.out.println(op1_int + " (int) + " + op2_byte + " (byte) = " + (op1_int + op2_byte) + " (int)");
        System.out.println(op1_int + " (int) + " + op2_short + " (short) = " + (op1_int + op2_short) + " (int)");
        System.out.println(op1_int + " (int) + '" + op2_char + "' (char) = " + (op1_int + op2_char) + " (int)");
        System.out.println(op1_int + " (int) + " + op2_int + " (int) = " + (op1_int + op2_int) + " (int)");
        System.out.println(op1_int + " (int) + " + op2_long + " (long) = " + (op1_int + op2_long) + " (long)");
        System.out.println(op1_int + " (int) + " + op2_float + " (float) = " + (op1_int + op2_float) + " (float)");
        System.out.println(op1_int + " (int) + " + op2_double + " (double) = " + (op1_int + op2_double) + " (double)");
        System.out.println(op1_int + " (int) + " + op2_boolean + " (boolean) = Compile Time Error (Cannot add numeric to boolean)");
        System.out.println(op1_int + " (int) + \"" + op2_string + "\" (String) = \"" + (op1_int + op2_string) + "\" (String - Concatenation)");


        System.out.println("\n=============================================");
        System.out.println("5. First Operand is long");
        System.out.println("=============================================");
        long op1_long = 1000L;
        System.out.println(op1_long + " (long) + " + op2_byte + " (byte) = " + (op1_long + op2_byte) + " (long)");
        System.out.println(op1_long + " (long) + " + op2_short + " (short) = " + (op1_long + op2_short) + " (long)");
        System.out.println(op1_long + " (long) + '" + op2_char + "' (char) = " + (op1_long + op2_char) + " (long)");
        System.out.println(op1_long + " (long) + " + op2_int + " (int) = " + (op1_long + op2_int) + " (long)");
        System.out.println(op1_long + " (long) + " + op2_long + " (long) = " + (op1_long + op2_long) + " (long)");
        System.out.println(op1_long + " (long) + " + op2_float + " (float) = " + (op1_long + op2_float) + " (float)"); // Long to float conversion
        System.out.println(op1_long + " (long) + " + op2_double + " (double) = " + (op1_long + op2_double) + " (double)");
        System.out.println(op1_long + " (long) + " + op2_boolean + " (boolean) = Compile Time Error (Cannot add numeric to boolean)");
        System.out.println(op1_long + " (long) + \"" + op2_string + "\" (String) = \"" + (op1_long + op2_string) + "\" (String - Concatenation)");


        System.out.println("\n=============================================");
        System.out.println("6. First Operand is float");
        System.out.println("=============================================");
        float op1_float = 10.5f;
        System.out.println(op1_float + " (float) + " + op2_byte + " (byte) = " + (op1_float + op2_byte) + " (float)");
        System.out.println(op1_float + " (float) + " + op2_short + " (short) = " + (op1_float + op2_short) + " (float)");
        System.out.println(op1_float + " (float) + '" + op2_char + "' (char) = " + (op1_float + op2_char) + " (float)");
        System.out.println(op1_float + " (float) + " + op2_int + " (int) = " + (op1_float + op2_int) + " (float)");
        System.out.println(op1_float + " (float) + " + op2_long + " (long) = " + (op1_float + op2_long) + " (float)");
        System.out.println(op1_float + " (float) + " + op2_float + " (float) = " + (op1_float + op2_float) + " (float)");
        System.out.println(op1_float + " (float) + " + op2_double + " (double) = " + (op1_float + op2_double) + " (double)");
        System.out.println(op1_float + " (float) + " + op2_boolean + " (boolean) = Compile Time Error (Cannot add numeric to boolean)");
        System.out.println(op1_float + " (float) + \"" + op2_string + "\" (String) = \"" + (op1_float + op2_string) + "\" (String - Concatenation)");


        System.out.println("\n=============================================");
        System.out.println("7. First Operand is double");
        System.out.println("=============================================");
        double op1_double = 20.75;
        System.out.println(op1_double + " (double) + " + op2_byte + " (byte) = " + (op1_double + op2_byte) + " (double)");
        System.out.println(op1_double + " (double) + " + op2_short + " (short) = " + (op1_double + op2_short) + " (double)");
        System.out.println(op1_double + " (double) + '" + op2_char + "' (char) = " + (op1_double + op2_char) + " (double)");
        System.out.println(op1_double + " (double) + " + op2_int + " (int) = " + (op1_double + op2_int) + " (double)");
        System.out.println(op1_double + " (double) + " + op2_long + " (long) = " + (op1_double + op2_long) + " (double)");
        System.out.println(op1_double + " (double) + " + op2_float + " (float) = " + (op1_double + op2_float) + " (double)");
        System.out.println(op1_double + " (double) + " + op2_double + " (double) = " + (op1_double + op2_double) + " (double)");
        System.out.println(op1_double + " (double) + " + op2_boolean + " (boolean) = Compile Time Error (Cannot add numeric to boolean)");
        System.out.println(op1_double + " (double) + \"" + op2_string + "\" (String) = \"" + (op1_double + op2_string) + "\" (String - Concatenation)");

        System.out.println("\n=============================================");
        System.out.println("End of Demonstrations");
        System.out.println("=============================================");
    }
}