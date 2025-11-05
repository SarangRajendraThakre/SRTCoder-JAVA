public class P48_FindTripletsUniqueValues {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 10, 50};

        System.out.println("All unique-value triplets from the array are:");

        // Brute-force approach
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    // Ensure all three values are distinct
                    if (arr[i] != arr[j] && arr[i] != arr[k] && arr[j] != arr[k]) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    }
                }
            }
        }
    }
}
