
public class P48_FindTriplets {
    public static void main(String[] args) {
        // The array of numbers
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("All unique triplets from the array are: 🔢");

        // First loop to pick the first element
        for (int i = 0; i < arr.length; i++) {
            // Second loop to pick the second element (starts after i)
            for (int j = i + 1; j < arr.length; j++) {
                // Third loop to pick the third element (starts after j)
                for (int k = j + 1; k < arr.length; k++) {
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                }
            }
        }
    }
}