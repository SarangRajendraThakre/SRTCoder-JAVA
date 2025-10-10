import java.util.Arrays;

public class P1_BubbleSort2 {

    public static void main(String[] args) {

        int[] arr = { 2, 5, 6, 3, 7, 4 };
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("------After  Bubble sorting --------");
        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int arr[]) {
        boolean isSwapped = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped == false)
                break;

        }

    }

}

// https://gemini.google.com/app/eeb2644dc73ffd4a
