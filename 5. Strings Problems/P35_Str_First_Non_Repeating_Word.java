import java.util.LinkedHashMap;
import java.util.Map;

public class P35_Str_First_Non_Repeating_Word {

    public static void main(String[] args) {
        String text = "the cat saw the dog and the dog ran";
        String result = findFirstNonRepeatingWord(text);

        if (result == null) {
            System.out.println("No non-repeating word found.");
        } else {
            System.out.println("The first non-repeating word is: \"" + result + "\"");
        }

        String text2 = "apple banana apple banana";
        String result2 = findFirstNonRepeatingWord(text2);
        if (result2 == null) {
            System.out.println("No non-repeating word found in \"" + text2 + "\".");
        }
    }

    /**
     * Finds the first word in a string that appears only once.
     * @param text The input string of words.
     * @return The first non-repeating word, or null if none exists.
     */
    public static String findFirstNonRepeatingWord(String text) {
        // Handle empty or null input
        if (text == null || text.trim().isEmpty()) {
            return null;
        }

        // Split text into words. "\\s+" handles multiple spaces.
        String[] words = text.trim().split("\\s+");

        // Use a LinkedHashMap to maintain insertion order while counting.
        Map<String, Integer> wordCounts = new LinkedHashMap<>();

        // 1. Count the frequency of each word.
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // 2. Find the first word in the map with a count of 1.
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey(); // This is the first non-repeating word.
            }
        }

        // 3. If no word has a count of 1, return null.
        return null;
    }
}