package maxminnoinarray;

import java.util.Arrays;

public class maxinarray1 {
    static maxinarray getminmax(int arr[], int n) {
        maxinarray obj1 = new maxinarray();
        Arrays.sort(arr);
        obj1.min = arr[0];
        obj1.max = arr[n - 1];
        return obj1;

    }

    public static void main(String[] args) {
        int arr[] = { 45, 35442, 5, 4, 364, 45 };
        int arr_size = arr.length;
        maxinarray obj1 = getminmax(arr, arr_size);
        System.out.println("minimum number in array :" + obj1.min);
        System.out.println("maximum number in array : " + obj1.max);

    }

}
