import java.util.Arrays;

public class P5_MergeSort {

  
    public static void main(String[] args) {
        int[] arr = { 7,3,2,16};

        System.out.println("Original array: " + Arrays.toString(arr));

        // Call the sorting method
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:   " + Arrays.toString(arr));

    }



   
    public static void mergeSort(int[] arr, int left, int right) {
        // Base case: if the sub-array has more than one element
        if (left < right) {
            // Find the middle point to divide the array into two halves
            int middle = left + (right - left) / 2;

            // Recursively sort the first half
            mergeSort(arr, left, middle);
            // Recursively sort the second half
            mergeSort(arr, middle + 1, right);

            // Merge the sorted halves

         merge(arr, left, middle, right);

        }
    }


    private static void merge(int[] arr, int left, int middle, int right) {
        // Find sizes of the two temporary sub-arrays to be merged
        int size1 = middle - left + 1;
        int size2 = right - middle;

        // Create temporary arrays
        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        // Copy data to the temporary arrays
        for (int i = 0; i < size1; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < size2; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // --- The merging process ---

        // Initial indexes of the two sub-arrays and the merged array
        int i = 0, j = 0;
        int k = left; // k is the index for the original array

        // Compare elements from leftArray and rightArray and place the smaller one
        // into the original array
        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of leftArray[], if there are any
        while (i < size1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements of rightArray[], if there are any
        while (j < size2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}