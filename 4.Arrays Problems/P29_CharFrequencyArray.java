import java.util.Scanner;

public class P29_CharFrequencyArray {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        // Assuming ASCII characters (0-255). For full Unicode, use charCounts[65536].
        int[] charCounts = new int[256]; 

        // Populate the frequency array
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            charCounts[c]++; 
        }

        System.out.println("Character frequencies:");
        // Iterate through the ASCII range to print frequencies of characters present in the string
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > 0) {
                System.out.println("'" + (char)i + "': " + charCounts[i]);
            }
        }

        scanner.close();
    }
}
