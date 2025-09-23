import java.util.Arrays;

public class P140_Insertion_Sort_Descending {

    public static void main(String[] args) {
        int[] arr = { 10, 50, 30, 343, 43, 5, 4, 34 };

        // Insertion Sort (Descending)
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift smaller elements to the right
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println("Sorted array in descending order: " + Arrays.toString(arr));
    }
}
