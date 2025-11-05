import java.util.Arrays;
import java.util.Scanner;

public class P24_ClockWiseRotationofArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Original Array: " + Arrays.toString(arr));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rotations: ");
        int rotations = sc.nextInt();

        // Using brute-force
        clockwiseRotationBruteForce(arr, rotations);
        System.out.println("After Brute Force Rotation: " + Arrays.toString(arr));

        // Reset array
        arr = new int[] { 1, 2, 3, 4, 5, 6 };

        // Using reversal method (optimized)
        clockwiseRotationOptimized(arr, rotations);
        System.out.println("After Optimized Rotation: " + Arrays.toString(arr));
    }

    // 🔹 Brute-force method (your original method)
    public static void clockwiseRotationBruteForce(int[] arr, int rotations) {
        int n = arr.length;
        rotations = rotations % n; // handle rotations > n
        for (int i = 1; i <= rotations; i++) {
            int temp = arr[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[0] = temp;
        }
    }

    // 🔹 Optimized method using array reversal
    public static void clockwiseRotationOptimized(int[] arr, int rotations) {
        int n = arr.length;
        rotations = rotations % n; // handle rotations > n
        reverse(arr, 0, n - 1);
        reverse(arr, 0, rotations - 1);
        reverse(arr, rotations, n - 1);
    }

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
