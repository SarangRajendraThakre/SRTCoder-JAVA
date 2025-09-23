public class P51_Str_Count_VowelsAndConsonantsInString {

    public static void main(String[] args) {
        String text = "Hello World! This is a test string.";
        
        int vowels = 0;
        int consonants = 0;

        // 1. Convert the string to lowercase to simplify checking
        String lowerCaseText = text.toLowerCase();

        // 2. Loop through each character of the string
        for (int i = 0; i < lowerCaseText.length(); i++) {
            char ch = lowerCaseText.charAt(i);

            // 3. Check if the character is a letter
            if (ch >= 'a' && ch <= 'z') {
                // 4. Check if the letter is a vowel
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    // If it's a letter but not a vowel, it's a consonant
                    consonants++;
                }
            }
            // Non-letter characters (spaces, punctuation, etc.) are ignored.
        }

        // 5. Print the results
        System.out.println("Original String: \"" + text + "\"");
        System.out.println("Total Vowels: " + vowels);
        System.out.println("Total Consonants: " + consonants);
    }
}