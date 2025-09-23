public class DemoJaggedArraySum {
    public static void main(String[] args) {
        System.out.println("\n--- Demo Jagged Array Sum ---");

        // Declaring and initializing a jagged array
        // Inner arrays have different lengths.
        int[][] jaggedArray = {
            {1, 2},         // Row 0 has 2 elements
            {3, 4, 5},      // Row 1 has 3 elements
            {6},            // Row 2 has 1 element
            {7, 8, 9, 10}   // Row 3 has 4 elements
        };

        int totalJaggedSum = 0;

        // Iterating through the jagged array using nested enhanced for-loops
        // The inner loop correctly adapts to the length of each row.
        for (int[] row : jaggedArray) {
            for (int element : row) {
                totalJaggedSum += element;
            }
        }

        System.out.println("Jagged Array elements:");
        for (int[] row : jaggedArray) {
            System.out.println(java.util.Arrays.toString(row));
        }
        System.out.println("The sum of all elements in the jagged array is: " + totalJaggedSum); // Expected: 45
    }
}