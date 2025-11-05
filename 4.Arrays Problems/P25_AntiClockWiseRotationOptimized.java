import java.util.Arrays;
import java.util.Scanner;

public class P25_AntiClockWiseRotationOptimized {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Before: " + Arrays.toString(arr));

        System.out.print("Enter the number of rotations: ");
        int rotations = new Scanner(System.in).nextInt();

        anticlockwiseRotationOptimized(arr, rotations);

        System.out.println("After Anticlockwise Rotation: " + Arrays.toString(arr));
    }

    public static void anticlockwiseRotationOptimized(int[] arr, int rotations) {
        int n = arr.length;
        rotations = rotations % n; // handle rotations > length

        // Step 1: Reverse first 'rotations' elements
        reverse(arr, 0, rotations - 1);

        // Step 2: Reverse remaining elements
        reverse(arr, rotations, n - 1);

        // Step 3: Reverse the whole array
        reverse(arr, 0, n - 1);
    }

    // Helper method to reverse a subarray
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
