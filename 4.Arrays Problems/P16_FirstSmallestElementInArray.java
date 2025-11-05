import java.util.Arrays;

public class P16_FirstSmallestElementInArray {

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 6, 23, 4, 9};

        System.out.println("Original Array: " + Arrays.toString(arr));

        System.out.println("\n--- Method 1: Using Simple Loop ---");
        findSmallestElementLoop(arr);

        System.out.println("\n--- Method 2: Using Arrays.sort() ---");
        findSmallestElementUsingSort(arr);

        System.out.println("\n--- Method 3: Using Stream API ---");
        findSmallestElementUsingStream(arr);
    }

    // 🔹 Method 1: Simple loop (O(n))
    public static void findSmallestElementLoop(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int ele : arr) {
            if (ele < min) {
                min = ele;
            }
        }
        System.out.println("Smallest Element (Loop): " + min);
    }

    // 🔹 Method 2: Using sorting (O(n log n))
    public static void findSmallestElementUsingSort(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        System.out.println("Smallest Element (Sorted): " + sorted[0]);
    }

    // 🔹 Method 3: Using Stream API (O(n))
    public static void findSmallestElementUsingStream(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println("Smallest Element (Stream API): " + min);
    }
}
