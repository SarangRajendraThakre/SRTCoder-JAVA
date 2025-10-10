import java.util.Arrays;
import java.util.HashMap;

public class P170_Two_sum {

    public static void main(String[] args) {
        // Your code here

        int[] arr = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = twoSum_Brute_force(arr, target);
        System.out.println(Arrays.toString(result));

        System.out.println(
                Arrays.toString(twoSum_Two_Pointers_approach_sortedArray_Needed(new int[] { 2, 3, 5, 10 }, 13)));

        System.out.println(
                Arrays.toString(twoSumHashMap(new int[] { 2, 3, 5, 10 }, 13)));

        System.out.println(
                Arrays.toString(twoSumBinarySearch(new int[] { 2, 3, 5, 10 }, 13)));

    }

    // brute force approach

    public static int[] twoSum_Brute_force(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    // two pointer approach
    public static int[] twoSum_Two_Pointers_approach_sortedArray_Needed(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[] { left, right };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {};

    }

    // BinarySearch
    public static int[] twoSumBinarySearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            int j = Arrays.binarySearch(arr, i + 1, arr.length, complement);
            if (j >= 0) {
                return new int[] { i, j };
            }

        }
        return new int[] {};

    }

    // hashmap
    public static int[] twoSumHashMap(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(arr[i], i);
        }

        return new int[] {};

    }

}

// https://leetcode.com/problems/two-sum/description/

// https://chatgpt.com/c/68e78f72-e6c4-8324-9d14-7b5de2af7220