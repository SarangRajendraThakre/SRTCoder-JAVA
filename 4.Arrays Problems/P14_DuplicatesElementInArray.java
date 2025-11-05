import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P14_DuplicatesElementInArray {

    public static void main(String[] args) {

        int[] arr = { 2, 3, 5, 6, 7, 54, 34, 6, 2 };

        System.out.println("Original Array: " + Arrays.toString(arr));

        System.out.println("\n--- Method 1: Simple Brute Force ---");
        duplicateElementBruteForce(arr);

        System.out.println("\n--- Method 2: Brute Force Optimized ---");
        duplicateElementBruteForceOptimize(arr);

        System.out.println("\n--- Method 3: Using HashMap ---");
        duplicateElementHashMap(arr);

        System.out.println("\n--- Method 4: Using Stream API ---");
        duplicateElementStreamAPI(arr);
    }

    // 🔹 Method 1: Basic brute force O(n²)
    public static void duplicateElementBruteForce(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                }
            }
        }
    }

    // 🔹 Method 2: Optimized brute force using boolean visited array
    public static void duplicateElementBruteForceOptimize(int[] arr) {
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }

            if (count > 1) {
                System.out.println(arr[i] + " : " + count);
            }
        }
    }

    // 🔹 Method 3: Using HashMap
    public static void duplicateElementHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    // 🔹 Method 4: Using Stream API
    public static void duplicateElementStreamAPI(int[] arr) {
        Map<Integer, Long> freqMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        freqMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}
