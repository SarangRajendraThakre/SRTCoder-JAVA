import java.util.Arrays;
import java.util.Arrays;
import java.util.OptionalInt;

public class P20_SecondSmallestElement {

    public static void main(String[] args) {
        int[] arr = { 23, 44, 34, -4, 56, 653, 75, 66, 5, 54, 54, 47, 75, 6, 5, 4, 44, 3, 76, 7756, 567, 87 };

        System.out.println("Array: " + Arrays.toString(arr));

        // --- Using Loop ---
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int ele : arr) {
            if (ele < firstMin) {
                secondMin = firstMin;
                firstMin = ele;
            } else if (ele < secondMin && ele > firstMin) { // ✅ ensures secondMin is distinct
                secondMin = ele;
            }
        }

        System.out.println("First Minimum (Loop): " + firstMin);
        System.out.println("Second Minimum (Loop): " + secondMin);

        // --- Using Stream API ---
        OptionalInt secondMinStream = Arrays.stream(arr)
                .distinct()             // remove duplicates
                .sorted()               // sort in ascending order
                .skip(1)                // skip the first smallest
                .findFirst();           // get the second smallest

        System.out.println("Second Minimum (Stream API): " + secondMinStream.getAsInt());
    }
}
