import java.util.Arrays;

public class A8_Arrays_Method_BinarySearch_Object {

    public static void main(String[] args) {
        // 1. Create an array of Objects (Strings in this case)
        String[] cities = {"Mumbai", "Agra", "Chennai", "Delhi", "Bengaluru"};

        // 2. IMPORTANT: The array must be sorted before using binarySearch.
        // String has a natural alphabetical ordering.
        System.out.println("Original unsorted array: " + Arrays.toString(cities));
        Arrays.sort(cities);
        System.out.println("Sorted array: " + Arrays.toString(cities));
        System.out.println("-------------------------------nb---------");

        // --- Scenario 1: Searching for an object that EXISTS ---
        String keyToFind = "Delhi";
        System.out.println("Searching for the key: \"" + keyToFind + "\"");

        int foundIndex = Arrays.binarySearch(cities, keyToFind);

        if (foundIndex >= 0) {
            System.out.println("Success! The key was found at index: " + foundIndex);
        } else {
            System.out.println("Failure! This shouldn't happen for an existing key.");
        }

        System.out.println("----------------------------------------");

        // --- Scenario 2: Searching for an object that does NOT EXIST ---
        String keyNotFound = "Goa";
        System.out.println("Searching for the key: \"" + keyNotFound + "\"");

        int notFoundIndex = Arrays.binarySearch(cities, keyNotFound);

        if (notFoundIndex >= 0) {
            System.out.println("Failure! This shouldn't happen for a non-existing key.");
        } else {
            // The result for a non-found key is (-(insertion point) - 1)
            System.out.println("As expected, the key was not found.");
            System.out.println("The method returned the value: " + notFoundIndex);

            // We can calculate where it would be inserted
            int insertionPoint = -notFoundIndex - 1;
            System.out.println("To keep the array sorted, \"" + keyNotFound + "\" would be inserted at index: " + insertionPoint);
        }
    }
}