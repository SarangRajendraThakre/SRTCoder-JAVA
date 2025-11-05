import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P18_FirstLeastRepeatingElement {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, -3, -3, 4, 2, 5, 6, 7, 7 };

        System.out.println("Original Array: " + Arrays.toString(arr));

        System.out.println("\n--- Method 1: Brute Force ---");
        int[] bf = findLeastRepeatingElementBruteForce(arr);
        System.out.println("Min Count: " + bf[0] + ", Element: " + bf[1]);

        System.out.println("\n--- Method 2: HashMap ---");
        int[] hm = findLeastRepeatingElementHashMap(arr);
        System.out.println("Min Count: " + hm[0] + ", Element: " + hm[1]);

        System.out.println("\n--- Method 3: Stream API ---");
        int[] st = findLeastRepeatingElementStream(arr);
        System.out.println("Min Count: " + st[0] + ", Element: " + st[1]);
    }

    // 🔹 Brute Force
    public static int[] findLeastRepeatingElementBruteForce(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        int minCount = Integer.MAX_VALUE;
        int minElement = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }

            if (count < minCount) {
                minCount = count;
                minElement = arr[i];
            }
        }

        return new int[]{minCount, minElement};
    }

    // 🔹 HashMap Approach
    public static int[] findLeastRepeatingElementHashMap(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int minCount = Integer.MAX_VALUE;
        int minElement = arr[0];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < minCount) {
                minCount = entry.getValue();
                minElement = entry.getKey();
            }
        }

        return new int[]{minCount, minElement};
    }

    // 🔹 Stream API Approach
    public static int[] findLeastRepeatingElementStream(int[] arr) {
        Map<Integer, Long> freqMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Map.Entry<Integer, Long> minEntry = freqMap.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow();

        return new int[]{minEntry.getValue().intValue(), minEntry.getKey()};
    }
}
