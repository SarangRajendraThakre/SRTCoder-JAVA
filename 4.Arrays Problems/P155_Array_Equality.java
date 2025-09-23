import java.util.Arrays;

public class P155_Array_Equality {

    public static void main(String[] args) {
        // Example 1: Equal arrays
        int[] arr1 = {24, 6, 545, 6, 76, 754, 343};
        int[] arr2 = {24, 6, 545, 6, 76, 754, 343};

        if (isEqual(arr1, arr2)) {
            System.out.println("Arrays 1 and 2 are equal."); // Correct output
        } else {
            System.out.println("Arrays 1 and 2 are not equal.");
        }

        // Example 2: Unequal arrays
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {1, 5, 3};

        if (isEqual(arr3, arr4)) {
            System.out.println("Arrays 3 and 4 are equal.");
        } else {
            System.out.println("Arrays 3 and 4 are not equal."); // Correct output
        }
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        // 1. Check if lengths are different. If so, they can't be equal.
        if (arr1.length != arr2.length) {
            return false;
        }

        // 2. Loop through and compare elements at each index.
        for (int i = 0; i < arr1.length; i++) {
            // If any element is different, return false immediately.
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        // 3. If the loop completes, all elements matched. The arrays are equal.
        return true;
    }
}