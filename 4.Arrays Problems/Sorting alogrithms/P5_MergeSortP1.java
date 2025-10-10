import java.util.Arrays;

public class P5_MergeSortP1 {

    public static void main(String[] args) {
        int[] arr = { 7, 3, 2, 16 };

        System.out.println("Original array: " + Arrays.toString(arr));

        // Call the sorting method
        divide(arr, 0, arr.length - 1);

        System.out.println("Sorted array:   " + Arrays.toString(arr));

    }

    public static void divide(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            divide(arr, left, middle);
            divide(arr, middle + 1, right);
            conquer(arr, left, middle, right);
        }
    }

    private static void conquer(int[] arr, int left, int middle, int right) {

        int[] merged = new int[right - left + 1];

        int index1 = left;
        int index2 = middle + 1;
        int x = 0;

        while (index1 <= middle && index2 <= right) {
            if (arr[index1] < arr[index2]) {

                merged[x++] = arr[index1++];
            } else {
                merged[x++] = arr[index2++];
            }

        }

        while (index1 <= middle) {
            merged[x++] = arr[index1++];
        }
        while (index2 <= right) {
            merged[x++] = arr[index2++];
        }

        for (int i = 0; i < merged.length; i++) {
            arr[left + i] = merged[i];
        }

    }
}