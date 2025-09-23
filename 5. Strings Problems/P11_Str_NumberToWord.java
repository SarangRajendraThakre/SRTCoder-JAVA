import java.util.Scanner;

public class P11_Str_NumberToWord  {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (0-1000): ");
        int num = scanner.nextInt();
        String word = solve(num);
        System.out.println(num + " : " + word);
        scanner.close(); // It's good practice to close the scanner
    }

    private static String solve(int num) {
        String[] dgt = {
                "Zero", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine"
        };
        String[] tens = {
                "", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"
        };
        String[] arr = { // For numbers 11-19
                "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                "Nineteen"
        };

        if (num > 1000) {
            return "INVALID NUMBER";
        }
        if (num == 1000) {
            return "Thousand";
        }

        String word = "";

        // Handle hundreds place
        if (num >= 100) {
            word += dgt[num / 100] + " Hundred";
            if (num % 100 != 0) { // If there are tens or units after hundreds
                word += " and "; // Add "and" for numbers like "One Hundred and Twenty"
            }
        }

        // Handle numbers less than 100
        int remainder = num % 100;

        if (remainder >= 11 && remainder <= 19) {
            word += arr[remainder - 11];
        } else if (remainder >= 20 || remainder == 10 || remainder == 0) { // Handle tens and single digits (0-9)
            // Handle tens place
            if (remainder >= 10) {
                word += tens[remainder / 10];
                if (remainder % 10 != 0) { // If there's a unit digit
                    word += " ";
                }
            }
            // Handle units place (if not part of 11-19 and not a pure multiple of 10)
            if (remainder % 10 != 0) {
                word += dgt[remainder % 10];
            } else if (remainder == 0 && num < 100) { // Special case for "Zero" if num is 0-99 and just 0
                if (num == 0) {
                    word = dgt[0]; // "Zero"
                }
            } else if (remainder == 0 && num >= 100 && num % 100 == 0) {
                 // Do nothing if it's a pure hundred like 100, 200, etc.
                 // The "and" would have been added if there were more digits
            } else if (remainder == 10) { // For exactly "Ten"
                word += tens[1];
            }
        } else if (remainder > 0 && remainder < 10) { // For single digits (1-9) when num is < 100
            word += dgt[remainder];
        }


        // Special case for 0
        if (num == 0) {
            return dgt[0];
        }

        // Clean up any leading/trailing spaces or " and "
        return word.trim().replaceAll(" and $", "");
    }
}