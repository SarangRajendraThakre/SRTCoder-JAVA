
import java.util.*;

public class P152_MakeAllElements_Odd_or_Even {

    public static void main(String[] args) {
        // Your code here

        int[] arr = { 43, 6, 7,2,6,8};

        int oddCount = 0;
        int EvenCount = 0;

        for (int ele : arr) {
            if (ele % 2 == 0)
                EvenCount++;
            else
                oddCount++;
        }
        if (EvenCount > oddCount) {
            boolean isEven = true;
            System.out.println(Arrays.toString(incrementByOne(isEven, arr)));

        } else {
            boolean isEven = false;
            System.out.println(Arrays.toString(incrementByOne(isEven, arr)));
        }
    }

    public static int[] incrementByOne(boolean isEven, int[] arr) {
        if (isEven) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    arr[i] = arr[i] + 1;
                }
            }

        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    arr[i] = arr[i] + 1;
                }
            }
        }
        return arr;
    }
}
