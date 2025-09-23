import java.util.Arrays;

public class A17_Arrays_Method_Mismatch {
    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30, 40, 50};
        int[] arr2 = {10, 20, 99, 40, 50}; // Mismatch at index 2
        int[] arr3 = {10, 20, 30, 40, 50}; // Identical to arr1
        int[] arr4 = {10, 20, 30};      // A prefix of arr1

        // Case 1: A mismatch is found
        int mismatchIndex1 = Arrays.mismatch(arr1, arr2);
        System.out.printf("Mismatch between arr1 and arr2: %d (since arr1[2]!=arr2[2])\n", mismatchIndex1);

        // Case 2: Arrays are identical
        int mismatchIndex2 = Arrays.mismatch(arr1, arr3);
        System.out.printf("Mismatch between arr1 and arr3: %d (no mismatch)\n", mismatchIndex2);

        // Case 3: One array is a prefix of the other
        int mismatchIndex3 = Arrays.mismatch(arr1, arr4);
        System.out.printf("Mismatch between arr1 and arr4: %d (arr4 is a prefix)\n", mismatchIndex3);
    }
}