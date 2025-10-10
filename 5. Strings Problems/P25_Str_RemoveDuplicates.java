import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P25_Str_RemoveDuplicates {

    public static void main(String[] args) {
        String[] strings = {"Apple", "Banana", "Apple", "Grapes", "Banana"};
        
        // Remove duplicates while preserving the original order using Stream API
        String[] distinctStrings = removeDuplicates(strings);

        // Print the result
        System.out.println("Original array: " + Arrays.toString(strings));
        System.out.println("Array without duplicates (order preserved): " + Arrays.toString(distinctStrings));
    }
    
    /**
     * Removes duplicates from a String array while preserving the original order.
     * * @param array The input array of strings.
     * @return A new array with duplicates removed, preserving the original order.
     */
    public static String[] removeDuplicates(String[] array) {
        // 1. Convert the array to a Stream
        return Arrays.stream(array)
                     // 2. Use the distinct() intermediate operation to filter out duplicates.
                     //    This operation maintains the encounter order for ordered streams.
                     .distinct()
                     // 3. Collect the resulting elements back into a new String array.
                     .toArray(String[]::new);
    }


    //  public static String[] removeDuplicates(String[] array) {
    //     // 1. Create a LinkedHashSet to store distinct elements in insertion order.
    //     Set<String> distinctSet = new LinkedHashSet<>(Arrays.asList(array));

    //     // 2. Convert the LinkedHashSet back into a String array.
    //     return distinctSet.toArray(new String[0]);
}