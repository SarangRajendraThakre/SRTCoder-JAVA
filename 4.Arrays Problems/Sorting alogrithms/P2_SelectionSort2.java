import java.util.Arrays;

public class P2_SelectionSort2 {

    public static void main(String[] args) {

        int[] arr = { 2, 5, 6, 3, 7, 4 };
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("------After  Selection sorting --------");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallestIndex] > arr[j]) {
                    smallestIndex = j;
                }

            }
            if (smallestIndex != i) {
                int temp = arr[i];
                arr[i] = arr[smallestIndex];
                arr[smallestIndex] = temp;
            }
        }
    }

}

// https://gemini.google.com/app/376835c6909e4fbc