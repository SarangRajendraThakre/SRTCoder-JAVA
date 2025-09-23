import java.util.Scanner;

public class P11_Str_NumberToWordStringOnly{



    private static final String[] units = {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (0-1000): ");
        int num = scanner.nextInt();
        String word = convertNumberToWords(num);
        System.out.println(num + " : " + word);
        scanner.close();
    }

    public static String convertNumberToWords(int num) {
        if (num < 0 || num > 1000) {
            return "INVALID NUMBER";
        }
        if (num == 1000) {
            return "One Thousand";
        }
        if (num == 0) {
            return "Zero";
        }

        String words = ""; // Initialize with an empty string

        // Handle hundreds
        if (num >= 100) {
            words += units[num / 100] + " Hundred"; // String concatenation
            num %= 100; // Get the remainder after hundreds
            if (num > 0) {
                words += " and "; // String concatenation
            }
        }

        // Handle tens and units
        if (num > 0) {
            if (num < 20) {
                words += units[num]; // String concatenation
            } else {
                words += tens[num / 10]; // String concatenation
                if (num % 10 != 0) {
                    words += " " + units[num % 10]; // String concatenation
                }
            }
        }

        return words.trim(); // Trim any leading/trailing spaces
    }
}