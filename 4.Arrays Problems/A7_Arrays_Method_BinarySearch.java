import java.util.Arrays;

public class A7_Arrays_Method_BinarySearch {
 public static void main(String[] args) {
        int[] numbers = {10, 50, 40, 20, 30};

        // 1. THE GOLDEN RULE: Sort the array first!
        Arrays.sort(numbers);
        // The array is now: {10, 20, 30, 40, 50}


        // 2. Search for an element that exists
        int indexFound = Arrays.binarySearch(numbers, 40);
        System.out.println("Element 40 found at index: " + indexFound); // Output: 3

        // 3. Search for an element that does NOT exist
        int indexNotFound = Arrays.binarySearch(numbers, 25);
        // Insertion point for 25 is index 2 (between 20 and 30)
        // Result will be -(2) - 1 = -3
        System.out.println("Element 25 not found. Returned value: " + indexNotFound); // Output: -3

        // You can calculate the insertion point from the return value
        int insertionPoint = -indexNotFound - 1;
        System.out.println("The insertion point for 25 would be: " + insertionPoint); // Output: 2
    }
}