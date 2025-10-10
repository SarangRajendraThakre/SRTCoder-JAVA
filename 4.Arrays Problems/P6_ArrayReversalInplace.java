import java.util.Arrays;
import java.util.stream.IntStream;

public class P6_ArrayReversalInplace {

    public static void reverseArrayInPlace(int[] arr) {
    // Handle null or empty arrays gracefully
    if (arr == null || arr.length <= 1) {
    return; // No need to reverse if it's null, empty, or has only one element
    }

    int start = 0;
    int end = arr.length - 1;

    while (start < end) {
    // Swap elements at start and end
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;

    // Move pointers inward
    start++;
    end--;
    }
    }

    // public static void reverseArrayInPlace(int[] arr) {
    //     if (arr == null || arr.length <= 1) {
    //         return; // Nothing to reverse
    //     }

    //     IntStream.range(0, arr.length / 2)
    //             .forEach(i -> {
    //                 int temp = arr[i];
    //                 arr[i] = arr[arr.length - 1 - i];
    //                 arr[arr.length - 1 - i] = temp;
    //             });
    // }

    public static void main(String[] args) {
        int[] myArray1 = { 1, 2, 3, 4, 5 };
        System.out.println("Original array 1: " + Arrays.toString(myArray1));
        reverseArrayInPlace(myArray1);
        System.out.println("Reversed array 1 (in-place): " + Arrays.toString(myArray1)); // Output: [5, 4, 3, 2, 1]

        int[] myArray2 = { 10, 20, 30, 40 }; // Even number of elements
        System.out.println("Original array 2: " + Arrays.toString(myArray2));
        reverseArrayInPlace(myArray2);
        System.out.println("Reversed array 2 (in-place): " + Arrays.toString(myArray2)); // Output: [40, 30, 20, 10]

        int[] myArray3 = { 100 }; // Single element array
        System.out.println("Original array 3: " + Arrays.toString(myArray3));
        reverseArrayInPlace(myArray3);
        System.out.println("Reversed array 3 (in-place): " + Arrays.toString(myArray3)); // Output: [100]

        int[] myArray4 = {}; // Empty array
        System.out.println("Original array 4: " + Arrays.toString(myArray4));
        reverseArrayInPlace(myArray4);
        System.out.println("Reversed array 4 (in-place): " + Arrays.toString(myArray4)); // Output: []

        int[] myArray5 = null;
        System.out.println("Original array 5: " + myArray5);
        reverseArrayInPlace(myArray5);
        System.out.println("Reversed array 5 (in-place): " + myArray5);
    }
}