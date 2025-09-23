public class P42_CableArrangementCost {


    /**
     * Calculates the minimum total cost to arrange cables.
     * Alice can rearrange the cables in any order.
     * Costs are incurred for '01' patterns (X rupees) and '10' patterns (Y rupees).
     *
     * @param N The length of the binary string S. (Can also use S.length())
     * @param X The cost of a '01' pattern.
     * @param Y The cost of a '10' pattern.
     * @param S The given binary string representing cables.
     * @return The minimum total cost.
     */
    public static int calculateMinCost(int N, int X, int Y, String S) {
        
        int zerosCount = 0;
        int onesCount = 0;

        // Count the occurrences of '0's and '1's
        for (char c : S.toCharArray()) {
            if (c == '0') {
                zerosCount++;
            } else if (c == '1') { // Ensure only '0' or '1' are processed
                onesCount++;
            }
        }

        if (zerosCount == 0 || onesCount == 0) {
            return 0;
        } else {
    
            return Math.min(X, Y);
        }
    }

    public static void main(String[] args) {
        // Example 1 from the problem description
        System.out.println("Test Case 1:");
        int n1 = 4;
        int x1 = 7;
        int y1 = 3;
        String s1 = "1101";
        System.out.println("Input: N=" + n1 + ", X=" + x1 + ", Y=" + y1 + ", S=\"" + s1 + "\"");
        System.out.println("Result: " + calculateMinCost(n1, x1, y1, s1)); // Expected: 3

        System.out.println("\n---");

        // Example 2 from the problem description
        System.out.println("Test Case 2:");
        int n2 = 5;
        int x2 = 5;
        int y2 = 6;
        String s2 = "00000";
        System.out.println("Input: N=" + n2 + ", X=" + x2 + ", Y=" + y2 + ", S=\"" + s2 + "\"");
        System.out.println("Result: " + calculateMinCost(n2, x2, y2, s2)); // Expected: 0

        System.out.println("\n---");

        // Additional Test Cases
        System.out.println("Test Case 3 (S contains only 1s):");
        int n3 = 3;
        int x3 = 10;
        int y3 = 2;
        String s3 = "111";
        System.out.println("Input: N=" + n3 + ", X=" + x3 + ", Y=" + y3 + ", S=\"" + s3 + "\"");
        System.out.println("Result: " + calculateMinCost(n3, x3, y3, s3)); // Expected: 0

        System.out.println("\n---");

        System.out.println("Test Case 4 (Both 0s and 1s, X is smaller):");
        int n4 = 5;
        int x4 = 2;
        int y4 = 8;
        String s4 = "00110"; // Contains two 0s and three 1s.
        System.out.println("Input: N=" + n4 + ", X=" + x4 + ", Y=" + y4 + ", S=\"" + s4 + "\"");
        System.out.println("Result: " + calculateMinCost(n4, x4, y4, s4)); // Expected: 2 (min(2,8))

        System.out.println("\n---");

        System.out.println("Test Case 5 (Both 0s and 1s, Y is smaller):");
        int n5 = 6;
        int x5 = 30;
        int y5 = 10;
        String s5 = "101000";
        System.out.println("Input: N=" + n5 + ", X=" + x5 + ", Y=" + y5 + ", S=\"" + s5 + "\"");
        System.out.println("Result: " + calculateMinCost(n5, x5, y5, s5)); // Expected: 10 (min(15,10))
    }
}