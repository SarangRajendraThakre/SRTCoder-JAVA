import java.util.Scanner;

public class P28_HighestRepeatingCharArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        if (str == null || str.isEmpty()) {
            System.out.println("String is empty or null.");
            scanner.close();
            return;
        }

        // Create an array to store character counts.
        // Assuming ASCII characters (0-255). If dealing with full Unicode characters,
        // you would need a larger array or a different approach (like a HashMap,
        // which you're trying to avoid here).
        int[] charCounts = new int[256]; 

        // Populate the frequency array
        // Iterate through each character of the input string
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // Increment the count for the character at its ASCII value index
            charCounts[c]++; 
        }

        char highestRepeatingChar = '\0'; // Initialize with null character
        int maxCount = -1; // Initialize with -1 to ensure any valid count is greater

        // Iterate through the character counts array to find the character
        // with the highest frequency.
        // We iterate from 0 to 255 (the range of ASCII characters).
        for (int i = 0; i < charCounts.length; i++) {
            // If the current character's count is greater than the current maxCount
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i]; // Update maxCount
                highestRepeatingChar = (char)i; // Update the highest repeating character
            }
        }
        
        // Edge case: If the string contains only unique characters (e.g., "abc"),
        // then maxCount will be 1. The highestRepeatingChar will be the last
        // character encountered with a count of 1. You might want to clarify
        // how to handle this scenario if "repeating" implies more than 1 occurrence.
        // For this specific problem, it implies finding the character with the highest count,
        // even if that count is 1 (meaning it's the "highest" because no other character
        // has a higher count, and it appears at least once).

        System.out.println("Highest repeating character: '" + highestRepeatingChar + "' with " + maxCount + " occurrences.");

        scanner.close();
    }
}