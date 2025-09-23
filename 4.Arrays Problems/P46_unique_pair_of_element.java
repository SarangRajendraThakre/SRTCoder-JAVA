

public class P46_unique_pair_of_element {
    public static void main(String[] args) {
        // Define the integer array
        int[] arr = {10, 20, 30, 40};

        System.out.println("All possible unique pairs from the array are:");

        // Outer loop to pick the first element of the pair
        for (int i = 0; i < arr.length; i++) {
            // Inner loop to pick the second element of the pair
            // j starts from i + 1 to avoid duplicate pairs (e.g., 20 10) and self-pairs (e.g., 10 10)
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + " " + arr[j]);
            }
        }
    }
}