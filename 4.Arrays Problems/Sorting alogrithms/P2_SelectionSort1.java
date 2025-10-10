import java.util.Arrays;

public class P2_SelectionSort1 {

    public static void main(String[] args) {

        int[] arr = { 2, 5, 6, 3, 7, 4 };
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("------After  Selection sorting --------");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

}

// https://gemini.google.com/app/376835c6909e4fbc