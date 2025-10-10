package String;

import java.util.*;

public class Sort0and1and2 {
    public static void sortArray(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[mid] and arr[low]
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++; // Move ahead as 1 is in the correct place
            } else {
                // Swap arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--; // Do not increment mid, as the swapped value needs checking
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        sortArray(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
