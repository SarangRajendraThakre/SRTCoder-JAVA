import java.util.Arrays;

public class A11_Arrays_Method_CopyOfRange {
    public static void main(String[] args) {
        String[] months = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", 
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };
        System.out.println("Original Array: " + Arrays.toString(months));
        System.out.println("-------------------------------------------------------------------");

        // We want to copy the "summer" months: Jun, Jul, Aug
        // These are at indices 5, 6, and 7.
        int fromIndex = 5; // inclusive
        int toIndex = 8;   // exclusive

        // Create a new array containing just the slice
        String[] summerMonths = Arrays.copyOfRange(months, fromIndex, toIndex);
        
        System.out.printf("Copied a slice from index %d to %d...\n", fromIndex, toIndex);
        System.out.println("Resulting Sub-Array: " + Arrays.toString(summerMonths));
    }
}