import java.util.*;
import java.util.stream.*;

public class P23_SecondHighestRepeatingElementP {

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
    public static void secondHighestRepeatingBruteForce(int [] arr)
    {
        int firstHighCount = Integer.MIN_VALUE;
        int firstHighEle  = Integer.MIN_VALUE;
        int secondHighCount = Integer.MIN_VALUE;
        int secondHighEle  = Integer.MIN_VALUE;

        boolean[] visited = new boolean[arr.length];

        for(int i =0;i<arr.length;i++)
        {
            if(visited[i]) continue;

            int count = 1;
            for(int j = i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    count++;
                    visited[j]=true;
                }
            }
            if(count > firstHighCount)
            {
                secondHighCount = firstHighCount;
                firstHighCount  = count;
                secondHighEle = firstHighEle;
                firstHighEle = arr[i];
            }
            else if (  count > secondHighCount)
            {
                secondHighCount =  count;
                secondHighEle  = arr[i];
            }

        }
        System.out.println("firstHighEle is "+firstHighEle +" and its count is "+firstHighCount);
        System.out.println("second Hightest is "+secondHighEle +" and its count is "+secondHighCount);
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
