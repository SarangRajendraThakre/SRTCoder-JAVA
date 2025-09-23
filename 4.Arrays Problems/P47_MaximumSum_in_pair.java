

public class P47_MaximumSum_in_pair {
    public static void main(String[] args) {
        // The array of numbers
        // int[] arr = {10, 20, 30, 40};
        int[] arr = {10, 50, 30, 40};

        // Initialize max to the smallest possible value
        int max = Integer.MIN_VALUE;

        // Loop through all unique pairs
      for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                // Calculate the sum of the current pair
                int currentSum = arr[i] + arr[j];

                // If the current sum is greater than the max found so far, update max
                if (currentSum > max) {
                    max = currentSum;
                }
            }
        }

        // Print the final result
        System.out.println("The maximum sum of any two elements is: " + max);
    }
}