package String;

import java.util.*;

public class Airport_Dutch_National_Flag {
    public static void sortRiskLevels(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;

        // Count occurrences
        for (int num : arr) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        // Overwrite array
        int i = 0;
        while (count0-- > 0) arr[i++] = 0;
        while (count1-- > 0) arr[i++] = 1;
        while (count2-- > 0) arr[i++] = 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        sortRiskLevels(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
