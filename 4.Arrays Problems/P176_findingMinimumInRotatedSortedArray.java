
// log n time complexity

import java.util.Arrays;

public class P176_findingMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = { 6, 7, 1, 2, 3, 4, 5 };

        findingMinimumInRotatedSortedArray(arr);
    }

    // public static void findingMinimumInRotatedSortedArray(int[] arr) {

    // int left = 0;
    // int right = arr.length - 1;
    // int ans = arr[0];

    // if (arr.length == 1) {
    // System.out.println(arr[0]);
    // }
    // while (left <= right) {

    // if (arr[left] < arr[right]) {
    // ans = Math.min(ans, arr[left]);
    // }

    // int mid = (left + right) / 2;

    // ans = Math.min(ans, arr[mid]);
    // if (arr[left] <= arr[mid]) {
    // left = mid + 1;
    // } else {
    // right = mid - 1;
    // }
    // }

    // System.out.println(ans);

    // }

    public static void findingMinimumInRotatedSortedArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        int ans = arr[0];

        if (arr.length == 1) {
            System.out.println(arr[0]);
        }

        while (left <= right) {

            if (arr[left] < arr[right]) {
                ans = Math.min(ans, arr[left]);
            }
            int mid = (left + right) / 2;

            ans = Math.min(ans, arr[mid]);

            if (arr[left] <= arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        System.out.println(ans);

    }
}
