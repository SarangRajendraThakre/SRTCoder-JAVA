import java.util.*;
import java.util.stream.*;

public class P23_SecondHighestRepeatingElement {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 1, 2, 3, 5, 3, 5, 6, 7, 8, 9, 10, 10, 10, 12 };

        System.out.println("--- Brute Force ---");
        secondHighestRepeatingBruteForce(arr);

        System.out.println("\n--- HashMap Approach ---");
        secondHighestRepeatingHashMap(arr);

        System.out.println("\n--- Stream API Approach ---");
        secondHighestRepeatingStream(arr);
    }

    // 🔹 Brute Force
    public static void secondHighestRepeatingBruteForce(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        int firstHighCount = 0, secondHighCount = 0;
        Integer firstHighEle = null, secondHighEle = null;

        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                continue;

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && !visited[j]) {
                    count++;
                    visited[j] = true; // ✅ mark j as visited
                }
            }

            if (count > firstHighCount) {
                secondHighCount = firstHighCount;
                secondHighEle = firstHighEle;

                firstHighCount = count;
                firstHighEle = arr[i];
            } else if (count > secondHighCount && count < firstHighCount) {
                secondHighCount = count;
                secondHighEle = arr[i];
            }
        }

        System.out.println("First Highest: " + firstHighEle + " : " + firstHighCount);
        System.out.println("Second Highest: " + secondHighEle + " : " + secondHighCount);
    }

    // 🔹 HashMap Approach
    public static void secondHighestRepeatingHashMap(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        List<Map.Entry<Integer, Integer>> sorted = freq.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .toList();

        if (sorted.size() > 0)
            System.out.println("First Highest: " + sorted.get(0).getKey() + " : " + sorted.get(0).getValue());
        if (sorted.size() > 1)
            System.out.println("Second Highest: " + sorted.get(1).getKey() + " : " + sorted.get(1).getValue());
    }

    // 🔹 Stream API Approach
    public static void secondHighestRepeatingStream(int[] arr) {
        Map<Integer, Long> freq = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        List<Map.Entry<Integer, Long>> sorted = freq.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .toList();

        if (sorted.size() > 0)
            System.out.println("First Highest (Stream): " + sorted.get(0).getKey() + " : " + sorted.get(0).getValue());
        if (sorted.size() > 1)
            System.out.println("Second Highest (Stream): " + sorted.get(1).getKey() + " : " + sorted.get(1).getValue());
    }
}
