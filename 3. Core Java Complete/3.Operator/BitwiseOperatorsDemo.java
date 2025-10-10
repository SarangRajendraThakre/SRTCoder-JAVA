
public class BitwiseOperatorsDemo {

    public static void main(String[] args) {

        System.out.println("--- Java Bitwise Operators Demonstration ---");
        System.out.println("------------------------------------------");

        // --- Operands for demonstration ---
        int a = 5;  // Binary: ...0000 0101
        int b = 3;  // Binary: ...0000 0011
        int c = -5; // Binary: ...1111 1011 (two's complement)
        int d = -20; // Binary: ...1110 1100 (two's complement)

        System.out.println("\nInitial Values (32-bit binary for int):");
        System.out.println("a = " + a + " (Binary: " + toBinaryString(a) + ")");
        System.out.println("b = " + b + " (Binary: " + toBinaryString(b) + ")");
        System.out.println("c = " + c + " (Binary: " + toBinaryString(c) + ")");
        System.out.println("d = " + d + " (Binary: " + toBinaryString(d) + ")");
        System.out.println("------------------------------------------");

        // --- 1. Bitwise AND (&) ---
        System.out.println("\n--- 1. Bitwise AND (&) ---");
        // Result bit is 1 if BOTH corresponding bits are 1.
        int resultAnd = a & b; // 5 & 3 => 0101 & 0011 = 0001
        System.out.println("a & b (5 & 3) = " + resultAnd + " (Binary: " + toBinaryString(resultAnd) + ")");

        int resultAnd2 = c & b; // -5 & 3 => ...1111 1011 & ...0000 0011 = ...0000 0011
        System.out.println("c & b (-5 & 3) = " + resultAnd2 + " (Binary: " + toBinaryString(resultAnd2) + ")"); // Output will be 3


        // --- 2. Bitwise OR (|) ---
        System.out.println("\n--- 2. Bitwise OR (|) ---");
        // Result bit is 1 if AT LEAST ONE of the corresponding bits is 1.
        int resultOr = a | b; // 5 | 3 => 0101 | 0011 = 0111
        System.out.println("a | b (5 | 3) = " + resultOr + " (Binary: " + toBinaryString(resultOr) + ")");

        int resultOr2 = c | b; // -5 | 3 => ...1111 1011 | ...0000 0011 = ...1111 1011
        System.out.println("c | b (-5 | 3) = " + resultOr2 + " (Binary: " + toBinaryString(resultOr2) + ")"); // Output will be -5


        // --- 3. Bitwise XOR (^) ---
        System.out.println("\n--- 3. Bitwise XOR (^) ---");
        // Result bit is 1 if corresponding bits are DIFFERENT.
        int resultXor = a ^ b; // 5 ^ 3 => 0101 ^ 0011 = 0110
        System.out.println("a ^ b (5 ^ 3) = " + resultXor + " (Binary: " + toBinaryString(resultXor) + ")");

        int resultXor2 = c ^ b; // -5 ^ 3 => ...1111 1011 ^ ...0000 0011 = ...1111 1000
        System.out.println("c ^ b (-5 ^ 3) = " + resultXor2 + " (Binary: " + toBinaryString(resultXor2) + ")"); // Output will be -8


        // --- 4. Bitwise NOT / Complement (~) ---
        System.out.println("\n--- 4. Bitwise NOT / Complement (~) ---");
        // Inverts all bits. For signed integers, ~x results in -(x + 1).
        int resultNotA = ~a; // ~5 => ~0101 => ...1111 1010
        System.out.println("~a (~5) = " + resultNotA + " (Binary: " + toBinaryString(resultNotA) + ")"); // Output: -6

        int resultNotC = ~c; // ~(-5) => ~...1111 1011 => ...0000 0100
        System.out.println("~c (~(-5)) = " + resultNotC + " (Binary: " + toBinaryString(resultNotC) + ")"); // Output: 4


        // --- 5. Left Shift (<<) ---
        System.out.println("\n--- 5. Left Shift (<<) ---");
        // Shifts bits left. Vacated right bits filled with 0s.
        // Equivalent to multiplying by 2^n (if no overflow).
        int shiftLeftA = a << 2; // 5 << 2 => 0101 << 2 = 010100
        System.out.println("a << 2 (5 << 2) = " + shiftLeftA + " (Binary: " + toBinaryString(shiftLeftA) + ")"); // Output: 20

        int shiftLeftD = d << 1; // -20 << 1 => ...1110 1100 << 1 = ...1101 1000
        System.out.println("d << 1 (-20 << 1) = " + shiftLeftD + " (Binary: " + toBinaryString(shiftLeftD) + ")"); // Output: -40


        // --- 6. Signed Right Shift (>>) ---
        System.out.println("\n--- 6. Signed Right Shift (>>) ---");
        // Shifts bits right. Vacated left bits filled with sign bit (preserves sign).
        // Equivalent to integer division by 2^n.
        int shiftRightA = a >> 2; // 5 >> 2 => 0101 >> 2 = 0001
        System.out.println("a >> 2 (5 >> 2) = " + shiftRightA + " (Binary: " + toBinaryString(shiftRightA) + ")"); // Output: 1

        int shiftRightD = d >> 2; // -20 >> 2 => ...1110 1100 >> 2 = ...1111 1011
        System.out.println("d >> 2 (-20 >> 2) = " + shiftRightD + " (Binary: " + toBinaryString(shiftRightD) + ")"); // Output: -5


        // --- 7. Unsigned Right Shift (>>>) ---
        System.out.println("\n--- 7. Unsigned Right Shift (>>>) ---");
        // Shifts bits right. Vacated left bits ALWAYS filled with 0s (does NOT preserve sign).
        int unsignedShiftA = a >>> 2; // 5 >>> 2 => 0101 >>> 2 = 0001
        System.out.println("a >>> 2 (5 >>> 2) = " + unsignedShiftA + " (Binary: " + toBinaryString(unsignedShiftA) + ")"); // Output: 1 (Same as >> for positive)

        int unsignedShiftD = d >>> 2; // -20 >>> 2 => ...1110 1100 >>> 2 = 0011...1111 1011
        System.out.println("d >>> 2 (-20 >>> 2) = " + unsignedShiftD + " (Binary: " + toBinaryString(unsignedShiftD) + ")"); // Output: 1073741819 (Large positive number!)


        System.out.println("\n------------------------------------------");
        System.out.println("--- End of Bitwise Operators Demo ---");
    }

    /**
     * Helper method to get the 32-bit binary string representation of an int.
     * Pads with leading zeros for clarity.
     */
    public static String toBinaryString(int n) {
        String binary = Integer.toBinaryString(n);
        // Pad with leading zeros to ensure 32 bits for positive numbers
        // For negative numbers, Integer.toBinaryString already returns 32 bits.
        return String.format("%32s", binary).replace(' ', '0');
    }
}