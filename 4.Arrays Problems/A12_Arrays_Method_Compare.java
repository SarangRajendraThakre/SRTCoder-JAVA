import java.util.Arrays;

public class A12_Arrays_Method_Compare {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 8};
        int[] arr2 = {1, 5, 9}; // Difference at the last element
        int[] arr3 = {1, 5, 8}; // Identical to arr1
        int[] arr4 = {1, 5};   // Shorter than arr1

        // Comparing arr1 and arr2
        // It compares 1==1, 5==5, then 8 vs 9. Since 8 < 9, arr1 is less than arr2.
        int result1 = Arrays.compare(arr1, arr2);
        System.out.println("compare(arr1, arr2): " + result1); // Prints a negative number

        // Comparing arr1 and arr3
        // All elements are identical.
        int result2 = Arrays.compare(arr1, arr3);
        System.out.println("compare(arr1, arr3): " + result2); // Prints 0

        // Comparing arr1 and arr4
        // arr4 is a prefix of arr1, so it is "less than".
        int result3 = Arrays.compare(arr1, arr4);
        System.out.println("compare(arr1, arr4): " + result3); // Prints a positive number (because arr1 is longer)
    }
}