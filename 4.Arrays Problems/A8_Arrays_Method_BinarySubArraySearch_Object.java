
import java.util.Arrays;

public class A8_Arrays_Method_BinarySubArraySearch_Object {

    public static void main(String[] args) {

        // 1. A sorted array of objects (String implements Comparable)
        String[] fruits = {"Apple", "Banana", "Cherry", "Grape", "Kiwi", "Mango", "Orange", "Papaya"};
        
        System.out.println("Full Array: " + Arrays.toString(fruits));
        System.out.println("--------------------------------------------------");

        // 2. Define the search range: from index 2 up to (but not including) index 6.
        // The sub-array we are effectively searching is: {"Cherry", "Grape", "Kiwi", "Mango"}
        int fromIndex = 2;
        int toIndex = 6;
        System.out.printf("Searching in the range from index %d (inclusive) to %d (exclusive).\n\n", fromIndex, toIndex);

        // --- TEST CASE 1: Key is PRESENT within the search range ---
        String key1 = "Kiwi";
        int result1 = Arrays.binarySearch(fruits, fromIndex, toIndex, key1);
        System.out.printf("Searching for '%s'... \nResult: %d\n", key1, result1);
        // Explanation: 'Kiwi' is found at index 4 of the original array, which is within our range [2, 6).
        
        System.out.println();

        // --- TEST CASE 2: Key is NOT PRESENT within the search range (but exists elsewhere) ---
        String key2 = "Apple";
        int result2 = Arrays.binarySearch(fruits, fromIndex, toIndex, key2);
        System.out.printf("Searching for '%s'... \nResult: %d\n", key2, result2);
        // Explanation: 'Apple' is not in our search range. The method returns a negative
        // insertion point. It would be inserted at index 2, so the result is -(2) - 1 = -3.
        
        System.out.println();

        // --- TEST CASE 3: Key is NOT in the array at all ---
        String key3 = "Lemon";
        int result3 = Arrays.binarySearch(fruits, fromIndex, toIndex, key3);
        System.out.printf("Searching for '%s'... \nResult: %d\n", key3, result3);
        // Explanation: Within our range, 'Lemon' would be inserted at index 5.
        // The result is -(5) - 1 = -6.
    }
}