import java.util.Arrays;

public class A16_Arrays_Method_fill {
    public static void main(String[] args) {

        // 1. Create an array of size 8. It's initialized to all zeros by default.
        int[] gameScores = new int[8];
        System.out.println("Initial Array:          " + Arrays.toString(gameScores));

        // 2. Fill a portion of the array (from index 2 to 5) with the value 100.
        // The range includes indices 2, 3, 4, and 5.
        Arrays.fill(gameScores, 2, 6, 100);
        System.out.println("After filling range 2-6: " + Arrays.toString(gameScores));

        // 3. Fill the entire array with the value -1 to reset it.
        Arrays.fill(gameScores, -1);
        System.out.println("After filling all with -1: " + Arrays.toString(gameScores));
    }
}