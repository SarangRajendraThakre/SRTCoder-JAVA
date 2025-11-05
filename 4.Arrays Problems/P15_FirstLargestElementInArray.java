import java.util.Arrays;

public class P15_FirstLargestElementInArray {

    public static void main(String[] args) {
        int[] arr = { 3, 4, 4, 6, 23, 4, 9 };

        System.out.println("Original Array: " + Arrays.toString(arr));

        System.out.println("\n--- Method 1: Using Simple Loop ---");
        findLargestElementLoop(arr);

        System.out.println("\n--- Method 2: Using Arrays.sort() ---");
        findLargestElementUsingSort(arr);

        System.out.println("\n--- Method 3: Using Stream API ---");
        findLargestElementUsingStream(arr);
    }

    // 🔹 Method 1: Simple loop (O(n))
    public static void findLargestElementLoop(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            if (ele > max) {
                max = ele;
            }
        }
        System.out.println("Largest Element (Loop): " + max);
    }

    // 🔹 Method 2: Using sorting (O(n log n))
    public static void findLargestElementUsingSort(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        System.out.println("Largest Element (Sorted): " + sorted[sorted.length - 1]);
    }

    // 🔹 Method 3: Using Stream API (O(n))
    public static void findLargestElementUsingStream(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("Largest Element (Stream API): " + max);
    }
}
