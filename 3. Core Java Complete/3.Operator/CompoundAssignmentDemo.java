
public class CompoundAssignmentDemo {

    public static void main(String[] args) {

        System.out.println("--- Compound Assignment Operators Demonstration ---");
        System.out.println("-------------------------------------------------");

        // --- 1. Arithmetic Compound Assignment Operators ---
        System.out.println("\n--- Arithmetic Operators ---");

        int x = 10;
        System.out.println("Initial x = " + x);

        x += 5; // Equivalent to: x = x + 5;
        System.out.println("x += 5;   => x = " + x); // x is now 15

        x -= 3; // Equivalent to: x = x - 3;
        System.out.println("x -= 3;   => x = " + x); // x is now 12

        x *= 2; // Equivalent to: x = x * 2;
        System.out.println("x *= 2;   => x = " + x); // x is now 24

        x /= 4; // Equivalent to: x = x / 4;
        System.out.println("x /= 4;   => x = " + x); // x is now 6

        x %= 5; // Equivalent to: x = x % 5;
        System.out.println("x %= 5;   => x = " + x); // x is now 1 (remainder of 6 / 5)

        System.out.println("\n--- Implicit Casting with Compound Assignment ---");
        byte b = 10;
        System.out.println("Initial byte b = " + b);

        // This WILL COMPILE:
        b += 20; // Equivalent to: b = (byte)(b + 20);
        System.out.println("b += 20;  => b = " + b + " (10 + 20 = 30)");

        // This would cause a COMPILE-TIME ERROR without the cast:
        // byte result = b + 20; // Error: incompatible types: possible lossy conversion
        // from int to byte
        // Explanation: b (byte) is promoted to int for the addition, resulting in an
        // int.
        // Assigning an int back to a byte requires an explicit cast.

        // Example with overflow
        byte b2 = 100;
        System.out.println("Initial byte b2 = " + b2);
        b2 += 50; // Equivalent to: b2 = (byte)(b2 + 50); (100 + 50 = 150)
                  // 150 overflows byte range (-128 to 127), so it wraps around.
        System.out.println("b2 += 50; => b2 = " + b2 + " (Overflow: 100 + 50 = 150 -> -106)");

        // --- 2. Bitwise Compound Assignment Operators ---
        System.out.println("\n--- Bitwise Operators ---");

        int y = 12; // Binary: 0000...1100
        int z = 5; // Binary: 0000...0101
        System.out.println("Initial y = " + y + " (Binary: " + Integer.toBinaryString(y) + ")");
        System.out.println("Initial z = " + z + " (Binary: " + Integer.toBinaryString(z) + ")");

        y &= z; // Equivalent to: y = y & z; (1100 & 0101 = 0100)
        System.out.println("y &= z;   => y = " + y + " (Binary: " + Integer.toBinaryString(y) + ")"); // y is now 4

        y = 12; // Reset y
        y |= z; // Equivalent to: y = y | z; (1100 | 0101 = 1101)
        System.out.println("y |= z;   => y = " + y + " (Binary: " + Integer.toBinaryString(y) + ")"); // y is now 13

        y = 12; // Reset y
        y ^= z; // Equivalent to: y = y ^ z; (1100 ^ 0101 = 1001)
        System.out.println("y ^= z;   => y = " + y + " (Binary: " + Integer.toBinaryString(y) + ")"); // y is now 9

        int shiftVal = 16; // Binary: 0000...10000
        System.out.println("\nInitial shiftVal = " + shiftVal + " (Binary: " + Integer.toBinaryString(shiftVal) + ")");

        shiftVal <<= 2; // Equivalent to: shiftVal = shiftVal << 2; (10000 << 2 = 1000000)
        System.out.println(
                "shiftVal <<= 2; => shiftVal = " + shiftVal + " (Binary: " + Integer.toBinaryString(shiftVal) + ")"); // shiftVal
                                                                                                                      // is
                                                                                                                      // now
                                                                                                                      // 64

        shiftVal = 64; // Reset shiftVal
        shiftVal >>= 3; // Equivalent to: shiftVal = shiftVal >> 3; (1000000 >> 3 = 1000)
        System.out.println(
                "shiftVal >>= 3; => shiftVal = " + shiftVal + " (Binary: " + Integer.toBinaryString(shiftVal) + ")"); // shiftVal
                                                                                                                      // is
                                                                                                                      // now
                                                                                                                      // 8

        shiftVal = -64; // Binary: ...11000000
        System.out.println("Initial shiftVal = " + shiftVal + " (Binary: " + Integer.toBinaryString(shiftVal) + ")");
        shiftVal >>>= 4; // Equivalent to: shiftVal = shiftVal >>> 4;
        System.out.println(
                "shiftVal >>>= 4; => shiftVal = " + shiftVal + " (Binary: " + Integer.toBinaryString(shiftVal) + ")"); // Large
                                                                                                                       // positive
                                                                                                                       // number

        System.out.println("\n-------------------------------------------------");
        System.out.println("--- End of Compound Assignment Demo ---");
    }
}