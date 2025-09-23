package Operator;

public class IncrementDecrement {

    public static void main(String[] args) {
        System.out.println("--- Operator Precedence & Associativity Exercises ---");

        System.out.println("\n--- Problem 1 (P, q, r, S variables) ---");
        problemSet1();

        System.out.println("\n--- Problem 2 (Combined Operator Practice 1) ---");
        problemSet2();

        System.out.println("\n--- Problem 3 (Combined Operator Practice 2) ---");
        problemSet3();

        System.out.println("\n--- Problem 4 (Combined Operator Practice 3) ---");
        complexOperatorProblem();

        System.out.println("\n--- Problem 5 (Specific Trace: a=3, b=a++, b=b++) ---");
        specificTraceProblem();

        System.out.println("\n--- Interview Questions ---");
        System.out.println("Note: These are challenging. Try to predict before running!");

        System.out.println("\n--- Interview Q1: Compound Assignment ---");
        interviewQ1();

        System.out.println("\n--- Interview Q2: Multiple Increments/Decrements ---");
        interviewQ2();

        System.out.println("\n--- Interview Q3: Unary Ops & Precedence ---");
        interviewQ3();

        System.out.println("\n--- Interview Q4: Chained Assignments ---");
        interviewQ4();

        System.out.println("\n--- Interview Q5: Complex Nesting ---");
        interviewQ5();
    }

    // --- Original Problem Set from our chat ---

    // Problem from earlier discussion (Section 2 Variables P, q, r, S)
    // Note: The trace provided in the original image for P and r had some ambiguities,
    // so this code implements a direct interpretation of the expressions.
    public static void problemSet1() {
        int P = 13;
        int q = -3;
        int r = 86;
        int S = 5;

        System.out.println("Initial values: P=" + P + ", q=" + q + ", r=" + r + ", S=" + S);

        // Problem 1: P = q++ + r - --P
        // Expected trace for P: -3 + 86 - 12 = 71
        P = q++ + r - --P;
        System.out.println("After P = q++ + r - --P;");
        System.out.println("P = " + P + ", q = " + q + ", r = " + r + ", S = " + S);

        // Problem 2: S = --P + --q
        // Expected trace for S: 70 + (-3) = 67
        S = --P + --q;
        System.out.println("After S = --P + --q;");
        System.out.println("P = " + P + ", q = " + q + ", r = " + r + ", S = " + S);

        // Problem 3: r = r + P - --q
        // Expected trace for r: 86 + 70 - (-4) = 160 (if r started at 86 before this line)
        // Note: If r became 85 earlier due to some unstated side effect in the image, then 85 + 70 - (-4) = 159
        // We assume r's value from its last explicit state (86 for the calculation purpose here)
        r = r + P - --q;
        System.out.println("After r = r + P - --q;");
        System.out.println("P = " + P + ", q = " + q + ", r = " + r + ", S = " + S);
    }

    // Problem from Problem Set 1 (from our "combined operator practice problems" list)
    public static void problemSet2() {
        System.out.println("--- Problem from Combined Operator Practice Set 1 ---");
        int m = 5;
        int n = 2;
        int p = 10;

        System.out.println("Initial values: m=" + m + ", n=" + n + ", p=" + p);

        // Expected: result1 = 11, m=6, n=2, p=9
        int result1 = (m++ * n) + (--p / m);

        System.out.println("result1 = " + result1);
        System.out.println("Final values: m=" + m + ", n=" + n + ", p=" + p);
    }

    // Problem from Problem Set 2 (from our "combined operator practice problems" list)
    public static void problemSet3() {
        System.out.println("--- Problem from Combined Operator Practice Set 2 ---");
        int x = 8;
        int y = 3;
        int z = 1;

        System.out.println("Initial values: x=" + x + ", y=" + y + ", z=" + z);

        // Expected: result2 = 3, x=7, y=3, z=2
        int result2 = x-- + y * ++z - (x + y);

        System.out.println("result2 = " + result2);
        System.out.println("Final values: x=" + x + ", y=" + y + ", z=" + z);
    }

    // Problem from Problem Set 3 (from our "combined operator practice problems" list)
    public static void complexOperatorProblem() {
        System.out.println("--- Problem from Combined Operator Practice Set 3 ---");
        int a = 12;
        int b = 4;
        int c = 6;

        System.out.println("Initial values: a=" + a + ", b=" + b + ", c=" + c);

        // Line 1:
        // Expected: a=-3, b=5, c=5
        a = b++ + --c - a;
        System.out.println("After Line 1 (a = b++ + --c - a;):");
        System.out.println("Current values: a=" + a + ", b=" + b + ", c=" + c);

        // Line 2:
        // Expected: result3 = 10, a=-2, b=5, c=5
        int result3 = c * (a++ + b);

        System.out.println("result3 = " + result3);
        System.out.println("Final values: a=" + a + ", b=" + b + ", c=" + c);
    }

    // The problem specific to "a=3 b=a++ b=b++ sout(a+b)"
    public static void specificTraceProblem() {
        System.out.println("--- Specific Trace Problem (a = 3, b = a++, b = b++) ---");
        int a = 3;
        int b;

        System.out.println("Initial a=" + a);

        b = a++; // b gets 3, a becomes 4
        System.out.println("After b = a++; a=" + a + ", b=" + b);

        b = b++; // b gets 3 (value before increment), then b becomes 4 (from increment), then b is assigned 3.
        System.out.println("After b = b++; a=" + a + ", b=" + b);

        System.out.println("sout(a+b);");
        System.out.println("Output: " + (a + b)); // Expected: 4 + 3 = 7
    }


    // --- Interview Questions ---

    // Interview Q1: Compound Assignment
    public static void interviewQ1() {
        int x = 5;
        System.out.println("Initial x: " + x);
        x += ++x; // Equivalent to x = x + (++x);
        System.out.println("After x += ++x; x: " + x); // Expected: 11
    }

    // Interview Q2: Multiple Increments/Decrements in a Single Expression
    public static void interviewQ2() {
        int a = 10;
        int b = 20;
        System.out.println("Initial a: " + a + ", b: " + b);
        System.out.println("Result of (++a + b-- + a + b): " + (++a + b-- + a + b)); // Expected: 61
        System.out.println("Final a: " + a + ", b: " + b); // Expected: a=11, b=19
    }

    // Interview Q3: Unary Operators and Precedence with Parentheses
    public static void interviewQ3() {
        int num = 7;
        System.out.println("Initial num: " + num);
        // Expected: 12
        System.out.println("Result of ((num++ * 2) - (--num / 3)): " + ( (num++ * 2) - (--num / 3) ));
        System.out.println("Final num: " + num); // Expected: 7
    }

    // Interview Q4: Chained Assignments and Increment/Decrement
    public static void interviewQ4() {
        int x = 10;
        int y = 20;
        int z = 30;

        System.out.println("Initial x: " + x + ", y: " + y + ", z: " + z);

        // Expected: result = 580, x=11, y=19, z=29
        int result = x++ + (--y) * (z--);
        System.out.println("After result = x++ + (--y) * (z--); result: " + result);
        System.out.println("Current x: " + x + ", y: " + y + ", z: " + z);

        // Expected: x=29, y=29, z=29
        x = y = z;
        System.out.println("After x = y = z; Final x: " + x + ", y: " + y + ", z: " + z);
    }

    // Interview Q5: Complex Nesting and Order of Operations
    public static void interviewQ5() {
        int val = 2;
        System.out.println("Initial val: " + val);
        // Expected: 4
        System.out.println("Result of (val++ * (--val + val) / val): " + (val++ * (--val + val) / val));
        System.out.println("Final val: " + val); // Expected: 2
    }
}