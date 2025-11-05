import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P13_UniqueElementInArray {

    public static void main(String[] args) {

        int[] arr = { 2, 34, 5, 5, 2, 8, 5 };

        System.out.println("Original Array: " + Arrays.toString(arr));

        System.out.println("\n--- Method 1: Brute Force ---");
        uniqueElementsBruteForce(arr);

        System.out.println("\n--- Method 2: Using HashMap ---");
        uniqueElementsHashMap(arr);

        System.out.println("\n--- Method 3: Using Stream API ---");
        uniqueElementsStreamAPI(arr);
    }

    // 🔹 Method 1: Brute Force Approach
    public static void uniqueElementsBruteForce(int[] arr) {
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && !visited[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            if (count == 1) {
                System.out.println(arr[i] + " : " + count);
            }
        }
    }

    // 🔹 Method 2: Using HashMap
    public static void uniqueElementsHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    // 🔹 Method 3: Using Stream API
    public static void uniqueElementsStreamAPI(int[] arr) {
        Map<Integer, Long> freqMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        freqMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}
