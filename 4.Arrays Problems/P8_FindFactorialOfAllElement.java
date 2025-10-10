import java.util.Arrays;

public class P8_FindFactorialOfAllElement {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        findFactorial(arr);
        System.out.println(Arrays.toString(arr));
    }

    // public static void findFactorial(int[] arr) {

    // for (int i = 0; i < arr.length; i++) {
    // int num = arr[i];

    // if (num == 0 || num == 1) {
    // arr[i] = 1;
    // continue;
    // }

    // long factorial = 1;
    // for (int j = 2; j <= num; j++) {
    // factorial *= j;
    // }
    // arr[i] = (int) factorial;
    // }

    public static void findFactorial(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (num == 0 || num == 1) {
                arr[i] = 1;
                continue;
            }

            long factorial = 1;

            for (int j = 2; j <=num ; j++) {
                factorial *= j;

            }
            arr[i] = (int) factorial;

        }
    }

}