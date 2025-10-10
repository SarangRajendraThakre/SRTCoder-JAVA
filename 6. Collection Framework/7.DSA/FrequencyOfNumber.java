package String;

import java.util.*;

public class FrequencyOfNumber {
    public static void countFrequencies(int[] arr, int N, int P) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequencies only for elements <= N
        for (int num : arr) {
            if (num >= 1 && num <= N) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }

        // Step 2: Print frequencies from 1 to N
        for (int i = 1; i <= N; i++) {
            System.out.print(freqMap.getOrDefault(i, 0) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        countFrequencies(arr, N, P);
        sc.close();
    }
}
