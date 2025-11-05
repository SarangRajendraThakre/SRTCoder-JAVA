import java.util.HashSet;
import java.util.Set;

public class P46_unique_pair_of_element {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 10, 30, 20 };
        Set<String> seenPairs = new HashSet<>();

        System.out.println("All unique pairs ignoring duplicates:");

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i];
                int b = arr[j];
                // Sort pair so that (10 20) and (20 10) are treated the same
                String pair = a < b ? a + "," + b : b + "," + a;

                if (!seenPairs.contains(pair)) {
                    seenPairs.add(pair);
                    System.out.println(a + " " + b);
                }
            }
        }
    }
}