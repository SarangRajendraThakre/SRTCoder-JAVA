
import java.util.Arrays;

public class P49_MaxSumOfTriplet {
    public static void main(String[] args) {
        // The array of numbers
        // int[] arr = {10, 20, 30, 40, 50};
        int[] arr = { 10, 80, 30, 5, 50 };

        // Check if the array has at least 3 elements
        
        if (arr.length < 3) {
            System.out.println("Array must contain at least three elements.");
            return;
        }

        // Initialize maxSum to the smallest possible value

        int maxSum = Integer.MIN_VALUE;

        // Array to store the triplet that gives the max sum

        int[] resultTriplet = new int[3];

        // Loop through all unique triplets

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {

                    // Calculate the sum of the current triplet

                    int currentSum = arr[i] + arr[j] + arr[k];

                    // If the current sum is greater than the max found so far, update it

                    if (currentSum > maxSum) {
                        maxSum = currentSum;
                        resultTriplet[0] = arr[i];
                        resultTriplet[1] = arr[j];
                        resultTriplet[2] = arr[k];
                    }
                }
            }
        }

        // Print the final result

        System.out.println("The triplet with the maximum sum is: " + Arrays.toString(resultTriplet));
        System.out.println("Maximum Sum: " + maxSum);
    }
}