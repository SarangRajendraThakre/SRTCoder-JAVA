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

        System.out.println("The first maximum Element is " + firstMax + " Second max Element is " + secondMax);

    }
}