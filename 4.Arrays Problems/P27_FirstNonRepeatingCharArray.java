
import java.util.*;
public class P27_FirstNonRepeatingCharArray {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        if (str == null || str.isEmpty()) {
            System.out.println("Not found");
            scanner.close();
            return;
        }

        int[] charCounts = new int[256]; // For ASCII characters

        // First pass: Count character frequencies
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            charCounts[c]++;
        }

        char firstNonRepeating = '\0'; // Null character
        // Second pass: Iterate through the string to find the first non-repeating character
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charCounts[c] == 1) {
                firstNonRepeating = c;
                break; // Found the first one, so exit
            }
        }

        if (firstNonRepeating != '\0') {
            System.out.println("First non-repeating character: '" + firstNonRepeating + "'");
        } else {
            System.out.println("Not found");
        }

        scanner.close();
    }
}