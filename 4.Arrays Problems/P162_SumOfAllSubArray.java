public class P162_SumOfAllSubArray {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 6 };

        int n = arr.length;
        int totalSum = 0;

        // Outer loop → starting index
        for (int i = 0; i < n; i++) {
            int subArraySum = 0;

            // Inner loop → ending index
            for (int j = i; j < n; j++) {
                subArraySum += arr[j]; // Add current element
                totalSum += subArraySum; // Add to global sum

                System.out.println("Subarray [" + i + "..." + j + "] sum = " + subArraySum);
            }
        }

        System.out.println("Total sum of all subarrays = " + totalSum);
    }
}
