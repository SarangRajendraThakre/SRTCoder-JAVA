package TypeCasting;

public class SpecificNarrowingPaths {

    public static void main(String[] args) {

        System.out.println("--- Demonstrating Specific Narrowing Conversion Paths ---");
        System.out.println("Note: Each step requires explicit casting and can result in data loss.");
        System.out.println("----------------------------------------------------------");

        // --- Path 1: double -> float -> long -> int -> short -> byte ---
        System.out.println("\n--- Path 1: double -> float -> long -> int -> short -> byte ---");
        double dVal = 1234567890.12345; // A large double value

        System.out.println("Starting with double: " + dVal);

        // double to float (potential loss of precision, or overflow to Infinity)
        float dToF = (float) dVal;
        System.out.println("  double to float: " + dToF); // Will lose some precision

        // float to long (truncation of fractional part, potential overflow)
        long fToL = (long) dToF;
        System.out.println("  float to long: " + fToL); // Fractional part .12345 is lost

        // long to int (potential overflow/wrapping)
        int lToI = (int) fToL;
        System.out.println("  long to int: " + lToI); // Value fits in int, no overflow here

        // int to short (potential overflow/wrapping)
        short iToS = (short) lToI;
        System.out.println("  int to short: " + iToS); // Value fits in short, no overflow here

        // short to byte (potential overflow/wrapping)
        byte sToB = (byte) iToS;
        System.out.println("  short to byte: " + sToB); // Value fits in byte, no overflow here
        System.out.println("Final byte value: " + sToB);

        System.out.println("\n--- Example of significant data loss in this path ---");
        double dVal2 = 3.5e38; // A very large double, exceeds float MAX_VALUE
        System.out.println("Starting with double: " + dVal2);
        float dToF2 = (float) dVal2;
        System.out.println("  double to float: " + dToF2 + " (Note: Overflow to Infinity!)");
        long fToL2 = (long) dToF2; // Casting Infinity to long results in Long.MAX_VALUE
        System.out.println("  float to long: " + fToL2 + " (Note: Infinity cast to Long.MAX_VALUE)");
        int lToI2 = (int) fToL2; // Long.MAX_VALUE to int results in -1 due to overflow
        System.out.println("  long to int: " + lToI2 + " (Note: Overflow to -1)");


        // --- Path 2: float -> long -> int -> short -> byte ---
        System.out.println("\n--- Path 2: float -> long -> int -> short -> byte ---");
        float fVal = 987654.321f;

        System.out.println("Starting with float: " + fVal);

        // float to long (truncation of fractional part, potential overflow)
        long fToL_p2 = (long) fVal;
        System.out.println("  float to long: " + fToL_p2);

        // long to int (potential overflow/wrapping)
        int lToI_p2 = (int) fToL_p2;
        System.out.println("  long to int: " + lToI_p2);

        // int to short (potential overflow/wrapping)
        short iToS_p2 = (short) lToI_p2;
        System.out.println("  int to short: " + iToS_p2);

        // short to byte (potential overflow/wrapping)
        byte sToB_p2 = (byte) iToS_p2;
        System.out.println("  short to byte: " + sToB_p2);
        System.out.println("Final byte value: " + sToB_p2);


        // --- Path 3: long -> int -> short -> byte ---
        System.out.println("\n--- Path 3: long -> int -> short -> byte ---");
        long lVal = 50000; // A value that fits in int, short, byte
        long largeLVal = 3_000_000_000L; // 3 billion, will overflow int

        System.out.println("Starting with long: " + lVal);

        // long to int (potential overflow/wrapping)
        int lToI_p3 = (int) lVal;
        System.out.println("  long to int: " + lToI_p3);

        // int to short (potential overflow/wrapping)
        short iToS_p3 = (short) lToI_p3;
        System.out.println("  int to short: " + iToS_p3);

        // short to byte (potential overflow/wrapping)
        byte sToB_p3 = (byte) iToS_p3;
        System.out.println("  short to byte: " + sToB_p3);
        System.out.println("Final byte value: " + sToB_p3);

        System.out.println("\n--- Example of overflow in long -> int ---");
        System.out.println("Starting with long: " + largeLVal);
        int largeLToI = (int) largeLVal;
        System.out.println("  long to int: " + largeLToI + " (Note: Overflow! 3B -> 705032704)");


        // --- Path 4: int -> short -> byte ---
        System.out.println("\n--- Path 4: int -> short -> byte ---");
        int iVal = 300; // Value will overflow byte and short
        int negativeIVal = -150; // Negative value for overflow test

        System.out.println("Starting with int: " + iVal);

        // int to short (potential overflow/wrapping)
        short iToS_p4 = (short) iVal;
        System.out.println("  int to short: " + iToS_p4 + " (Overflow: 300 -> 300)"); // 300 fits in short

        // short to byte (potential overflow/wrapping)
        byte sToB_p4 = (byte) iToS_p4;
        System.out.println("  short to byte: " + sToB_p4 + " (Overflow: 300 -> 44)"); // 300 overflows byte
        System.out.println("Final byte value: " + sToB_p4);

        System.out.println("\n--- Example of overflow in int -> short ---");
        int intForShortOverflow = 35000; // Exceeds short's max (32767)
        System.out.println("Starting with int: " + intForShortOverflow);
        short intOverToShort = (short) intForShortOverflow;
        System.out.println("  int to short: " + intOverToShort + " (Overflow: 35000 -> -30536)");

        System.out.println("\n----------------------------------------------------------");
        System.out.println("--- End of Demonstrations ---");
    }
}