import java.util.Arrays;

public class P5_MergeSort {

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

    // private static void conquer(int[] arr, int left, int middle, int right) {
    // // Find sizes of the two temporary sub-arrays to be merged
    // int size1 = middle - left + 1;
    // int size2 = right - middle;

    // // Create temporary arrays
    // int[] leftArray = new int[size1];
    // int[] rightArray = new int[size2];

    // // Copy data to the temporary arrays
    // for (int i = 0; i < size1; ++i) {
    // leftArray[i] = arr[left + i];
    // }
    // for (int j = 0; j < size2; ++j) {
    // rightArray[j] = arr[middle + 1 + j];
    // }

    // // --- The merging process ---

    // // Initial indexes of the two sub-arrays and the merged array
    // int i = 0, j = 0;
    // int k = left; // k is the index for the original array

    // // Compare elements from leftArray and rightArray and place the smaller one
    // // into the original array
    // while (i < size1 && j < size2) {
    // if (leftArray[i] <= rightArray[j]) {
    // arr[k] = leftArray[i];
    // i++;
    // } else {
    // arr[k] = rightArray[j];
    // j++;
    // }
    // k++;
    // }

    // // Copy any remaining elements of leftArray[], if there are any
    // while (i < size1) {
    // arr[k] = leftArray[i];
    // i++;
    // k++;
    // }

    // // Copy any remaining elements of rightArray[], if there are any
    // while (j < size2) {
    // arr[k] = rightArray[j];
    // j++;
    // k++;
    // }
    // }

    private static void conquer(int[] arr, int left, int middle, int right) {
        int[] merged = new int[right - left + 1];
        int index1 = left;
        int index2 = middle + 1;
        int x = 0;

        // Merge elements into merged[]
        while (index1 <= middle && index2 <= right) {
            if (arr[index1] < arr[index2]) {
                merged[x++] = arr[index1++];
            } else {
                merged[x++] = arr[index2++];
            }
        }

        // Copy remaining elements from left side
        while (index1 <= middle) {
            merged[x++] = arr[index1++];
        }

        // Copy remaining elements from right side
        while (index2 <= right) {
            merged[x++] = arr[index2++];
        }

        // Copy merged[] back into original arr
        for (int i = 0; i < merged.length; i++) {
            arr[left + i] = merged[i];
        }
    }

}