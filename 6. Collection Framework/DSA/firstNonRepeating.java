package String;
import java.util.LinkedHashMap;
import java.util.Map;

class  firstNonRepeatingE {
    public static int firstNonRepeating(int[] arr) {
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();

        // Step 1: Count occurrences of each element
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the first element with frequency 1
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0; // If no non-repeating element is found
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, -1, 3, 2};
        System.out.println(firstNonRepeating(arr)); // Output: 3

        int[] arr1 = {1 , 1 ,1};
        System.out.println(firstNonRepeating(arr1)); // Output: 3
    }
}

