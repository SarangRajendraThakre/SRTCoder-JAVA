import java.util.Arrays;


public class A6_Arrays_Method_deepToString{

    public static void main(String[] args) {

        // --- First Example: 2D Array ---
        System.out.println("--- 2D Array Example ---");
        int[][] arr = {
            {1, 2},
            {3, 4},
            {5, 6},
            {7, 8}
        };

        // Using deepToString() to print the contents of the 2D array
        System.out.println("Output for 2D array:");
        System.out.println(Arrays.deepToString(arr));

        System.out.println(); // Adding a blank line for better readability

        // --- Second Example: 3D Array ---
        // Note: The declaration must be int[][][] to match the 3D initialization.
        System.out.println("--- 3D Array Example ---");
        int[][][] arr1 = {
            {
                {1, 2},
                {3, 4, 5}
            },
            {
                {6},
                {7, 8, 9, 10}
            }
        };

        // Using deepToString() to print the contents of the 3D array
        System.out.println("Output for 3D array:");
        System.out.println(Arrays.deepToString(arr1));
    }
}