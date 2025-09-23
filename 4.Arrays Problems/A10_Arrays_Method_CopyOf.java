import java.util.Arrays;

public class A10_Arrays_Method_CopyOf {
    public static void main(String[] args) {
        int[] originalScores = {85, 92, 78, 95, 88};
        System.out.println("Original Array: " + Arrays.toString(originalScores));
        System.out.println("----------------------------------------------");

        // 1. Truncating the array (copying only the first 3 elements)
        int[] topThree = Arrays.copyOf(originalScores, 3);
        System.out.println("Truncated Copy (length 3): " + Arrays.toString(topThree));

        // 2. Creating an exact copy of the array
        int[] exactCopy = Arrays.copyOf(originalScores, originalScores.length);
        System.out.println("Exact Copy (length 5):     " + Arrays.toString(exactCopy));

        // 3. Expanding the array (copying all elements and adding space)
        int[] expandedScores = Arrays.copyOf(originalScores, 7);
        System.out.println("Expanded Copy (length 7):  " + Arrays.toString(expandedScores));
    }
}