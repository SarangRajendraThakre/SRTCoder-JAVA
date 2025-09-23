public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String text = "swiss stress";
        char result = findFirst(text);

        if (result == '\0') { // '\0' is a null character, indicating no result
            System.out.println("No non-repeating character found in \"" + text + "\".");
        } else {
            System.out.println("The first non-repeating character in \"" + text + "\" is: '" + result + "'");
        }

        String text2 = "aabbcc";
        char result2 = findFirst(text2);
        if (result2 == '\0') {
             System.out.println("No non-repeating character found in \"" + text2 + "\".");
        }
    }

  
    public static char findFirst(String str) {
        // Handle invalid input
        if (str == null || str.isEmpty()) {
            return '\0';
        }

        // Create an array to store the frequency of characters (ASCII has 256 characters)
        int[] charCounts = new int[256];

        // 1. First pass: Populate the frequency count array.
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charCounts[ch]++; // Increment the count for the character's ASCII value
        }

        // 2. Second pass: Find the first character with a count of 1.
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (charCounts[ch] == 1) {
                return ch; // Found it!
            }
        }

        // If the loop finishes, no non-repeating character was found.
        return '\0';
    }
}