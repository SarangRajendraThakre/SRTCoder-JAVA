
public class P157_Rotate_Array_Right_Rotate {

    public static void main(String[] args) {
        // Your code here

        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

        rotateArr(arr, 2);

    }

    public static void rotateArr(int[] arr, int times) {
        for (int i = 0; i < times; i++) {
            int temp = arr[0];
            for (int j = 1; j < arr.length; j++)
             {
                arr[j-1] = arr[j];
            }
            arr[arr.length-1] = temp;
        }
        System.out.println(java.util.Arrays.toString(arr));
    }
}
