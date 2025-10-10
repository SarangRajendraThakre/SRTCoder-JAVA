import java.util.HashSet;
import java.util.Set;

public class P58_FindAPairWithGivenSum {

    public static void main(String[] args) {
        int[] arr = { 10, 20, 40, -10, 10 };
        int target = 30;

        Set<String> seen = new HashSet<>();
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    // Create ordered pair (smaller first)
                    int a = Math.min(arr[i], arr[j]);
                    int b = Math.max(arr[i], arr[j]);
                    String pair = a + "," + b;

                    if (!seen.contains(pair)) {
                        System.out.println("Pair found: (" + a + ", " + b + ")");
                        seen.add(pair);
                        found = true;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("No pair with sum " + target + " found.");
        }
    }
}
