public class P45_KadanesAlgorithm {

    public static void main(String[] args) {
        int[] arr = { 4, 4, -5, 34, -6, 65, -100 };

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("the maximum sum is : " + max);

    }
}