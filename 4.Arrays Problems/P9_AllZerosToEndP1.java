import java.util.Arrays;

public class P9_AllZerosToEndP1 {

    public static void main(String[] args) {

        int[] arr = { 2, 3, 4, 55, 6, 0, 54, 0, 0, 23, 3, 32, 23, 32, 24, 54 };

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] != 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}