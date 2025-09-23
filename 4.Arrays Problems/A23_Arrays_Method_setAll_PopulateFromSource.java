
import java.util.Arrays;

public class A23_Arrays_Method_setAll_PopulateFromSource {
    public static void main(String[] args) {
        int[] userIDs = {101, 105, 210, 315, 404};
        String[] formattedIDs = new String[userIDs.length];

        // The generator function accesses the 'userIDs' array.
        // For each index 'i', it creates a formatted string.
        Arrays.setAll(formattedIDs, i -> "User-ID-" + userIDs[i]);

        System.out.println("Formatted ID strings:");
        System.out.println(Arrays.toString(formattedIDs));
    }
}