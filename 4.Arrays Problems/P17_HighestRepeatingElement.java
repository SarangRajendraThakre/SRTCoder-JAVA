import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P17_HighestRepeatingElement {

    public static void main(String[] args) {

        int[] arr = { 3, 443, 5, 335, 454, 54, 55, 656, 34, 34, 34, 6, 54, 3 };

        System.out.println("Original Array: " + Arrays.toString(arr));

        System.out.println("\n--- Method 1: Brute Force ---");
        highestRepeatingElementBruteForce(arr);

        System.out.println("\n--- Method 2: Using HashMap ---");
        highestRepeatingElementHashMap(arr);

        System.out.println("\n--- Method 3: Using Stream API ---");
        highestRepeatingElementStreamAPI(arr);
    }

    // 🔹 Method 1: Brute Force
    public static void highestRepeatingElementBruteForce(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        int maxCount = 0;
        int maxElement = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                maxElement = arr[i];
            }
        }

        System.out.println("Highest Repeating Element (Brute Force): " + maxElement + " → " + maxCount + " times");
    }

    // 🔹 Method 2: HashMap
    public static void highestRepeatingElementHashMap(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>(); // preserves insertion order

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int maxElement = arr[0];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxElement = entry.getKey();
            }
        }

        System.out.println("Highest Repeating Element (HashMap): " + maxElement + " → " + maxCount + " times");
    }

    // 🔹 Method 3: Stream API
    public static void highestRepeatingElementStreamAPI(int[] arr) {
        Map<Integer, Long> freqMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Map.Entry<Integer, Long> maxEntry = freqMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (maxEntry != null) {
            System.out.println("Highest Repeating Element (Stream API): " +
                    maxEntry.getKey() + " → " + maxEntry.getValue() + " times");
        }
    }
}
