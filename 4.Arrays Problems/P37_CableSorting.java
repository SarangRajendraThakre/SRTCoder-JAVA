public class P37_CableSorting {

    public static int findMinSubstringsToSort(int N, String S) {

        if (N <= 1) {
            return 1;
        }

        int countRBTransitions = 0;

        for (int i = 0; i < N - 1; i++) {
            if (S.charAt(i) == 'R' && S.charAt(i + 1) == 'B') {
                countRBTransitions++;
            }
        }

        if (countRBTransitions == 0) {
            return 1;
        } else {

            return countRBTransitions + 1;
        }
    }

    public static void main(String[] args) {

        System.out.println("Test Case 1 (Problem Example):");
        String s1 = "BRRBR";
        System.out.println("Input S: \"" + s1 + "\", N: " + s1.length());
        System.out.println("Result: " + findMinSubstringsToSort(s1.length(), s1));

        System.out.println("\n---");

        System.out.println("Test Case 2 (Already Sorted: BBBRRR):");
        String s2 = "BBBRRR";
        System.out.println("Input S: \"" + s2 + "\", N: " + s2.length());
        System.out.println("Result: " + findMinSubstringsToSort(s2.length(), s2));

        System.out.println("\n---");

        System.out.println("Test Case 3 (Already Sorted: BBBBB):");
        String s3 = "BBBBB";
        System.out.println("Input S: \"" + s3 + "\", N: " + s3.length());
        System.out.println("Result: " + findMinSubstringsToSort(s3.length(), s3));

        System.out.println("\n---");

        System.out.println("Test Case 4 (Already Sorted: RRRRR):");
        String s4 = "RRRRR";
        System.out.println("Input S: \"" + s4 + "\", N: " + s4.length());
        System.out.println("Result: " + findMinSubstringsToSort(s4.length(), s4));

        System.out.println("\n---");

        System.out.println("Test Case 5 (Unsorted: RBRB):");
        String s5 = "RBRB";
        System.out.println("Input S: \"" + s5 + "\", N: " + s5.length());
        System.out.println("Result: " + findMinSubstringsToSort(s5.length(), s5));

        System.out.println("\n---");

        System.out.println("Test Case 6 (Unsorted: BRBRBR):");
        String s6 = "BRBRBR";
        System.out.println("Input S: \"" + s6 + "\", N: " + s6.length());

        System.out.println("Result: " + findMinSubstringsToSort(s6.length(), s6));

        System.out.println("\n---");

        System.out.println("Test Case 7 (Unsorted: RRBB):");
        String s7 = "RRBB";
        System.out.println("Input S: \"" + s7 + "\", N: " + s7.length());

        System.out.println("Result: " + findMinSubstringsToSort(s7.length(), s7));
    }
}