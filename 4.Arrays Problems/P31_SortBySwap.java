import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P31_SortBySwap {

    public static List<Character> sortBySwap(char[] arr, int N) {
        int left = 0;
        int mid = 0;
        int right = N - 1;
        while (mid <= right) {
            if (arr[mid] == '3') {
                char temp = arr[left];
                arr[left] = arr[mid];
                arr[mid] = temp;
                left++;
                mid++;
            } else if (arr[mid] == '6') {
                mid++;
            } else if (arr[mid] == '7') {
                char temp = arr[right];
                arr[right] = arr[mid];
                arr[mid] = temp;
                right--;
            }
            // IMPORTANT: If you pass characters other than '3', '6', '7',
            // this else block will prevent an infinite loop by moving mid forward.
            // However, the elements not being '3', '6', or '7' will not be sorted predictably.
            // else {
            //     mid++; // Optional: Move mid if character is not 3, 6, or 7.
            // }
        }
        List<Character> result = new ArrayList<>();
        for (char c : arr) {
            result.add(c);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter space-separated elements (3, 6, or 7 only): "); // Added clarification
        String input = scanner.nextLine();

        // --- CORRECTED PART ---
        String[] strChars = input.split("\\s+"); // Split by one or more spaces
        char[] arr = new char[strChars.length];

        for (int i = 0; i < strChars.length; i++) {
            // Take the first character of each "string" part (e.g., "3" -> '3')
            // This also handles cases where user might type "3" instead of just "3"
            if (!strChars[i].isEmpty()) { // Avoids issues with multiple leading/trailing spaces
                 arr[i] = strChars[i].charAt(0);
            } else {
                // Handle empty string if split resulted in one (e.g., "  3" -> "", "3")
                // You might want to skip or throw an error depending on strictness
                System.err.println("Warning: Empty element found. Skipping or handling as needed.");
                // For this example, we'll just continue, but a more robust solution might re-size the array
                // or validate input more strictly.
            }
        }
        // --- END CORRECTED PART ---

        List<Character> sortedArr = sortBySwap(arr, arr.length);
        for (char c : sortedArr) {
            System.out.print(c + " ");
        }
        System.out.println(); 
        scanner.close(); // Close the scanner to prevent resource leaks
    }
}