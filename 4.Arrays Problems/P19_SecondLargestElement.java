import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

public class P19_SecondLargestElement {

    public static void main(String[] args) {

        int[] arr = { 3, 4, 54, 6, 4, 43, 4, 34, 3, 5, 23, 2, 32, 32, 35, 6, 3, 34, 43, 3, 43, 34 };

        // --- Using Loop ---
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax && num < firstMax) { // ✅ fix for duplicates
                secondMax = num;
            }
        }

        System.out.println("First Max (Loop): " + firstMax);
        System.out.println("Second Max (Loop): " + secondMax);

        // --- Using Stream API ---
        usingTheStreamApi(arr);
    }

    // 🔹 Using Stream API
    public static void usingTheStreamApi(int[] arr) {
        OptionalInt secondLargest = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .mapToInt(Integer::intValue)
                .findFirst();

        System.out.println("Second Largest (Stream API): " + secondLargest.getAsInt());
    }
}
