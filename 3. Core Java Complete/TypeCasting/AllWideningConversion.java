public class AllWideningConversion {

    public static void main(String[] args) {

        System.out.println("--- Demonstrating Widening Primitive Conversions (Assignment) ---");
        System.out.println("Rule: Smaller types promote to larger types automatically.");
        System.out.println("Note: Conversions not shown or commented out require explicit casting (narrowing) or are incompatible.");
        System.out.println("------------------------------------------------------------------");

        // --- 1. Byte Widening ---
        System.out.println("\n--- 1. Byte Widening ---");
        byte b = 99; // Initial byte value (range: -128 to 127)

        int b_to_int = b;
        long b_to_long = b;
        float b_to_float = b;
        double b_to_double = b;
        short b_to_short = b; // byte to short is a valid widening conversion

        // char b_to_char = b; // Compile Time Error: Incompatible types.
                             // A byte can be negative, but a char is unsigned (0 to 65535).
                             // So, direct widening from byte to char is not allowed.
                             // Uncomment to see: incompatible types: possible lossy conversion from byte to char

        System.out.println("Original byte (b) = " + b);
        System.out.println("  to short (b_to_short) = " + b_to_short);
        System.out.println("  to int (b_to_int) = " + b_to_int);
        System.out.println("  to long (b_to_long) = " + b_to_long);
        System.out.println("  to float (b_to_float) = " + b_to_float);
        System.out.println("  to double (b_to_double) = " + b_to_double);


        // --- 2. Short Widening ---
        System.out.println("\n--- 2. Short Widening ---");
        short s = 1000; // Initial short value (range: -32768 to 32767)

        int s_to_int = s;
        long s_to_long = s;
        float s_to_float = s;
        double s_to_double = s;

        // byte s_to_byte = s; // Compile Time Error: Incompatible types.
                             // short is larger than byte (16-bit vs 8-bit). Narrowing conversion.
                             // Uncomment to see: incompatible types: possible lossy conversion from short to byte

        // char s_to_char = s; // Compile Time Error: Incompatible types.
                             // short is signed, char is unsigned. Direct widening not allowed.
                             // Uncomment to see: incompatible types: possible lossy conversion from short to char

        System.out.println("Original short (s) = " + s);
        System.out.println("  to int (s_to_int) = " + s_to_int);
        System.out.println("  to long (s_to_long) = " + s_to_long);
        System.out.println("  to float (s_to_float) = " + s_to_float);
        System.out.println("  to double (s_to_double) = " + s_to_double);


        // --- 3. Char Widening ---
        System.out.println("\n--- 3. Char Widening ---");
        char c = 'Z'; // Initial char value (ASCII/Unicode 90, range: 0 to 65535)

        int c_to_int = c;
        long c_to_long = c;
        float c_to_float = c;
        double c_to_double = c;

        // byte c_to_byte = c; // Compile Time Error: Incompatible types.
                             // char (unsigned) and byte (signed, smaller range) are incompatible for widening.
                             // Uncomment to see: incompatible types: possible lossy conversion from char to byte

        // short c_to_short = c; // Compile Time Error: Incompatible types.
                              // char (unsigned) and short (signed) are incompatible for widening.
                              // Uncomment to see: incompatible types: possible lossy conversion from char to short

        System.out.println("Original char (c) = '" + c + "' (ASCII/Unicode value: " + (int)c + ")");
        System.out.println("  to int (c_to_int) = " + c_to_int);
        System.out.println("  to long (c_to_long) = " + c_to_long);
        System.out.println("  to float (c_to_float) = " + c_to_float);
        System.out.println("  to double (c_to_double) = " + c_to_double);


        // --- 4. Int Widening ---
        System.out.println("\n--- 4. Int Widening ---");
        int i = 50000; // Initial int value (range: -2.1B to 2.1B)

        long i_to_long = i;
        float i_to_float = i;
        double i_to_double = i;

        // byte i_to_byte = i;   // Compile Time Error: int is larger than byte.
        // short i_to_short = i; // Compile Time Error: int is larger than short.
        // char i_to_char = i;   // Compile Time Error: int is larger than char.

        System.out.println("Original int (i) = " + i);
        System.out.println("  to long (i_to_long) = " + i_to_long);
        System.out.println("  to float (i_to_float) = " + i_to_float);
        System.out.println("  to double (i_to_double) = " + i_to_double);


        // --- 5. Long Widening ---
        System.out.println("\n--- 5. Long Widening ---");
        long l = 1234567890123L; // Initial long value (range: -9.2Q to 9.2Q)

        float l_to_float = l;   // long to float (potential precision loss for very large longs)
        double l_to_double = l;

        // byte l_to_byte = l;   // Compile Time Error: long is larger than byte.
        // short l_to_short = l; // Compile Time Error: long is larger than short.
        // char l_to_char = l;   // Compile Time Error: long is larger than char.
        // int l_to_int = l;     // Compile Time Error: long is larger than int.

        System.out.println("Original long (l) = " + l);
        System.out.println("  to float (l_to_float) = " + l_to_float + " (Note: Potential precision loss here for very large long values)");
        System.out.println("  to double (l_to_double) = " + l_to_double);


        // --- 6. Float Widening ---
        System.out.println("\n--- 6. Float Widening ---");
        float f = 123.45f; // Initial float value

        double f_to_double = f;

        // byte f_to_byte = f;   // Compile Time Error: float is not directly compatible with integer types.
        // short f_to_short = f; // Compile Time Error: float is not directly compatible with integer types.
        // char f_to_char = f;   // Compile Time Error: float is not directly compatible with integer types.
        // int f_to_int = f;     // Compile Time Error: float is not directly compatible with integer types.
        // long f_to_long = f;   // Compile Time Error: float is not directly compatible with integer types.

        System.out.println("Original float (f) = " + f);
        System.out.println("  to double (f_to_double) = " + f_to_double);


        // --- 7. Double Widening ---
        System.out.println("\n--- 7. Double Widening ---");
        double d = 987.654; // Initial double value

        // byte d_to_byte = d;   // Compile Time Error: double is not directly compatible with integer types.
        // short d_to_short = d; // Compile Time Error: double is not directly compatible with integer types.
        // char d_to_char = d;   // Compile Time Error: double is not directly compatible with integer types.
        // int d_to_int = d;     // Compile Time Error: double is not directly compatible with integer types.
        // long d_to_long = d;   // Compile Time Error: double is not directly compatible with integer types.
        // float d_to_float = d; // Compile Time Error: double is larger than float.

        System.out.println("Original double (d) = " + d);

        System.out.println("\n------------------------------------------------------------------");
        System.out.println("--- End of Demonstrations ---");
    }
}