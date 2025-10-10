import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P12_DistinctElementInArray {

    public static void main(String[] args) {

        int[] arr = { 2, 34, 5, 5, 2, 8, 5 };
        System.out.println("Original Array: " + Arrays.toString(arr));

        System.out.println("\n--- Method 1: Using Nested Loops and Boolean Array ---");
        findFrequencyUsingLoops(arr);

        System.out.println("\n--- Method 2: Using HashMap (Efficient Way) ---");
        findFrequencyUsingHashMap(arr);
    }

    // 🔹 Method 1: Using Nested Loops and Boolean Array
    public static void findFrequencyUsingLoops(int[] arr) {
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                continue; // Skip if already counted

            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && !visited[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(arr[i] + " : " + count);
        }
    }

    // 🔹 Method 2: Using HashMap
    // public static void findFrequencyUsingHashMap(int[] arr) {
    // Map<Integer, Integer> freq = new HashMap<>();

    // for (int num : arr) {
    // freq.put(num, freq.getOrDefault(num, 0) + 1);
    // }

    // for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
    // System.out.println(entry.getKey() + " : " + entry.getValue());
    // }
    // }

    public static void findFrequencyUsingHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

}
