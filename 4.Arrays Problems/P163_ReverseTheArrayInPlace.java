import java.util.Arrays;

public class P163_ReverseTheArrayInPlace {

    public static void main(String[] args) {
        int[] arr = {25, 575, 454, 34, 76, 654, 34};

      int left = 0;
      int right = arr.length-1;
      while (left < right) {
           int temp = arr[right];
           arr[right] = arr[left];
           arr[left] = temp;
           left++;
           right--;
      }

        System.out.println(Arrays.toString(arr));
    }
}
