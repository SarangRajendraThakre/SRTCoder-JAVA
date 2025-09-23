
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class P12_Str_RomanToDigit {



    public static int romanToInt(String s) {
        // Create a map to store the values of Roman numerals
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0; // To store the value of the previous Roman numeral

        // Iterate through the Roman numeral string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // If the current value is less than the previous value,
            // it means it's a subtractive case (e.g., IV, IX)
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue; // Update previous value for the next iteration
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral (e.g., IX, MCMXCIV): ");
        String romanNumeral = scanner.nextLine().toUpperCase(); // Convert to uppercase for consistent processing

        int digit = romanToInt(romanNumeral);

        if (digit == 0 && !romanNumeral.isEmpty() && !romanNumeral.equals("N")) { // 'N' can represent 0, but usually not converted
            System.out.println("Invalid Roman numeral or empty input.");
        } else {
            System.out.println("The integer equivalent of " + romanNumeral + " is: " + digit);
        }

        scanner.close();
    }
}