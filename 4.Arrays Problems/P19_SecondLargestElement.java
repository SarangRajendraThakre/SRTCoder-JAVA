import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

public class P19_SecondLargestElement {

    public static void main(String[] args) {

        int[] arr = { 3, 4, 54, 6, 4, 43, 4, 34, 3, 5, 23, 2, 32, 32, 35, 6, 3, 34, 43, 3, 43, 34 };

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }

        usingTheStreamApi(arr);

        System.out.println("The first maximum Element is " + firstMax + " Second max Element is " + secondMax);

    }

    // public static void usingTheStreamApi(int[] arr) {
    // int secondLargest = Arrays.stream(arr)
    // .boxed() // convert IntStream → Stream<Integer>
    // .distinct()
    // .sorted(Comparator.reverseOrder())
    // .skip(1)
    // .findFirst()
    // .orElseThrow(() -> new IllegalArgumentException("No Second Largest Element"));

    // System.out.println(secondLargest);
    // }

    public static void usingTheStreamApi(int[] arr) {
        OptionalInt secondLargest = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .mapToInt(Integer::intValue)
                .findFirst();

        System.out.println(secondLargest.getAsInt());

    }

}