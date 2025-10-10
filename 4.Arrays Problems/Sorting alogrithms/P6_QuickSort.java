import java.util.Arrays;

public class P6_QuickSort {

    public static void main(String[] args) {

        int[] arr = { 34, 6, 5, 34, 78, 3479, 23, 43 };

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot+1, right);
        }

    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left-1;

        for (int j = left; j < right; j++) // this loop is not running for upto pivot before only it is getting stoped
        {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }
        // for pivot
        i++;

        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;

    }
}




// https://gemini.google.com/app/d0b1079ee8941f78