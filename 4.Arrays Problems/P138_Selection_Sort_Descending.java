
public class P138_Selection_Sort_Descending {

    public static void main(String[] args) {
        // Your code here

        int[] arr = { 10, 50, 30, 343, 43, 5, 4, 34 };

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] < arr[j]) {
                    minIndex = j;
                }

            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println(java.util.Arrays.toString(arr));

    }
}
