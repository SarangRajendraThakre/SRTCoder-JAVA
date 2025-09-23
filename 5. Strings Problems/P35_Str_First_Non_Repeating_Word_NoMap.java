public class P35_Str_First_Non_Repeating_Word_NoMap {

    public static void main(String[] args) {
        String text = "the cat saw the dog and the dog ran";
        String result = findFirstNonRepeatingWord(text);

        if (result == null) {
            System.out.println("No non-repeating word found.");
        } else {
            System.out.println("The first non-repeating word is: \"" + result + "\"");
        }
    }

 
    public static String findFirstNonRepeatingWord(String text) {
        if (text == null || text.trim().isEmpty()) {
            return null;
        }

        String[] words = text.trim().split("\\s+");

        // 1. Outer loop: Selects a word to check.
        for (int i = 0; i < words.length; i++) {
            String wordToFind = words[i];
            int count = 0;

            // 2. Inner loop: Counts occurrences of the selected word.
            for (int j = 0; j < words.length; j++) {
                if (wordToFind.equals(words[j])) {
                    count++;
                }
            }

            // 3. Check the final count.
            if (count == 1) {
                return wordToFind; // Found it!
            }
        }

        // 4. If the loop finishes, no non-repeating word was found.
        return null;
    }
}