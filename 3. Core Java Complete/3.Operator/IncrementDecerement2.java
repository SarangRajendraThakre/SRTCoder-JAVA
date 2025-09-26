class IncrementDecerement2 {
    public static void main(String[] args) {

        System.out.println("--- Example 1 ---");
        int a1 = 2, b1 = 3;
        // a1++ = 2, then a1 becomes 3
        // b1++ = 3, then b1 becomes 4
        // a1 + b1 + b1++ + a1++ = 3 + 4 + 4 + 3
        int result1 = a1++ + b1++ + a1 + b1 + b1++ + a1++;
        System.out.println("Result: " + result1); // 19

        System.out.println("\n--- Example 2 ---");
        int a2 = 1;
        int b2 = a2++;  // b2 = 1, a2 = 2
        int result2 = a2++ + b2++ + b2 + a2; // 2 + 1 + 2 + 3
        System.out.println("Result: " + result2); // 8

        System.out.println("\n--- Example 3 ---");
        int a3 = 3;
        int b3 = a3++;  // b3 = 3, a3 = 4
        b3 = b3++;      // post-increment has no effect on b3
        int result3 = a3 + b3; // 4 + 3
        System.out.println("Result: " + result3); // 7

        System.out.println("\n--- Example 4 ---");
        int a4 = 3;
        int b4 = a4++;  // b4 = 3, a4 = 4
        int c4 = b4++;  // c4 = 3, b4 = 4
        int result4 = a4++ + b4++ + c4++ + a4 + b4 + c4;
        // Calculation step by step:
        // a4++ = 4, a4=5
        // b4++ = 4, b4=5
        // c4++ = 3, c4=4
        // a4=5, b4=5, c4=4
        // Sum = 4+4+3+5+5+4 = 25
        System.out.println("Result: " + result4); // 25
    }
}
