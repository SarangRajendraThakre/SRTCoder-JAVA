import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;

public class P11_FrequencyFinding {

    public static void main(String[] args) {

        int[] arr = { 2, 3, 45, 4, 6, 43, 3, 23, 232, 3, 656, 534, 343, 3 };

        System.out.println("\n--- Brute Force Approach ---\n");
        frequencyFindingBruteForce(arr);

        System.out.println("\n--- HashMap Approach ---\n");
        frequencyFindingHashMap(arr);

        System.out.println("\n--- Stream API Approach ---\n");
        frequencyFindingStreamAPI(arr);
    }

    // 🔹 Method 1: Brute Force
    public static void frequencyFindingBruteForce(int[] arr) {
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                continue;

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }

            System.out.println(arr[i] + " : " + count);
        }
    }

    // 🔹 Method 2: Using HashMap
    public static void frequencyFindingHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // 🔹 Method 3: Using Stream API
    public static void frequencyFindingStreamAPI(int[] arr) {
        Map<Integer, Long> freqMap = Arrays.stream(arr) // Convert array to IntStream
                .boxed() // Box int → Integer
                .collect(Collectors.groupingBy(
                        Function.identity(), // group by element value
                        Collectors.counting() // count occurrences
                ));

        freqMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
