import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P12_DistinctElementInArray {

    public static void main(String[] args) {

        int[] arr = { 2, 34, 5, 5, 2, 8, 5 };
        System.out.println("Original Array: " + Arrays.toString(arr));

        System.out.println("\n--- Method 1: Using Nested Loops and Boolean Array ---");
        findFrequencyUsingLoops(arr);

        System.out.println("\n--- Method 2: Using HashMap (Efficient Way) ---");
        findFrequencyUsingHashMap(arr);

        System.out.println("\n--- Method 3: Using Stream API ---");
        findFrequencyUsingStreamAPI(arr);
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
    public static void findFrequencyUsingHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // 🔹 Method 3: Using Stream API
    public static void findFrequencyUsingStreamAPI(int[] arr) {
        Map<Integer, Long> freqMap = Arrays.stream(arr)
                .boxed() // Convert int → Integer
                .collect(Collectors.groupingBy(
                        Function.identity(), // group by element value
                        Collectors.counting() // count each occurrence
                ));

        freqMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
