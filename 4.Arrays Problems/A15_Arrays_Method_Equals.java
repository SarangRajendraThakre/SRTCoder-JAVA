import java.util.Arrays;

public class A15_Arrays_Method_Equals {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30};
        int[] arr2 = {10, 20, 30};
        int[] arr3 = {30, 20, 10}; // Same elements, different order
        int[] arr4 = {10, 20};     // Different length

        // Case 1: Comparing two equal arrays
        boolean areEqual1 = Arrays.equals(arr1, arr2);
        System.out.println("Are arr1 and arr2 equal? " + areEqual1); // true

        // Case 2: Comparing arrays with different order
        boolean areEqual2 = Arrays.equals(arr1, arr3);
        System.out.println("Are arr1 and arr3 equal? " + areEqual2); // false

        // Case 3: Comparing arrays with different lengths
        boolean areEqual3 = Arrays.equals(arr1, arr4);
        System.out.println("Are arr1 and arr4 equal? " + areEqual3); // false
    }
}