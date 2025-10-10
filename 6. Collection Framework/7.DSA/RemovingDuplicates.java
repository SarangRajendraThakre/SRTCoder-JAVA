package String;

import java.util.Scanner;

public class RemovingDuplicates {
    public static int removeDuplicates(int[] arr, int N) {
        if (N == 0 || N == 1) return N; // Edge case: Empty array or single element
        
        int i = 0; // Pointer for unique elements

        // Traverse the array and overwrite duplicate elements
        for (int j = 1; j < N; j++) {
            if (arr[j] != arr[i]) { 
                i++; 
                arr[i] = arr[j]; // Store unique element
            }
        }

        return i + 1; // Number of distinct elements
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int X = removeDuplicates(arr, N);

        // Print only distinct elements
        for (int i = 0; i < X; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
