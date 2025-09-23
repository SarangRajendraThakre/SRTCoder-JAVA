

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P88_Str_AadhaarValidator {

    
    public static boolean isValidAadhaar(String aadhaarNumber) {
        // Regex to check for a 12-digit number not starting with 0 or 1.
        String regex = "^[2-9][0-9]{11}$";

        // 1. Compile the regex into a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // 2. If the aadhaarNumber is null, it's not valid
        if (aadhaarNumber == null) {
            return false;
        }

        // 3. Create a Matcher object and check for a full match
        Matcher matcher = pattern.matcher(aadhaarNumber);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // --- Test Cases ---
        String validAadhaar1 = "367598654321";
        String validAadhaar2 = "987654321012";

        String invalidAadhaar1 = "123456789012"; // Starts with 1
        String invalidAadhaar2 = "12345";          // Too short
        String invalidAadhaar3 = "1234567890123";  // Too long
        String invalidAadhaar4 = "A12345678901";   // Contains a letter
        String invalidAadhaar5 = null;             // Is null

        System.out.println("--- Aadhaar Number Validation ---");

        System.out.println(validAadhaar1 + ": " + (isValidAadhaar(validAadhaar1) ? "Valid" : "Invalid"));
        System.out.println(validAadhaar2 + ": " + (isValidAadhaar(validAadhaar2) ? "Valid" : "Invalid"));
        
        System.out.println("\n--- Invalid Examples ---");
        
        System.out.println(invalidAadhaar1 + ": " + (isValidAadhaar(invalidAadhaar1) ? "Valid" : "Invalid"));
        System.out.println(invalidAadhaar2 + ": " + (isValidAadhaar(invalidAadhaar2) ? "Valid" : "Invalid"));
        System.out.println(invalidAadhaar3 + ": " + (isValidAadhaar(invalidAadhaar3) ? "Valid" : "Invalid"));
        System.out.println(invalidAadhaar4 + ": " + (isValidAadhaar(invalidAadhaar4) ? "Valid" : "Invalid"));
        System.out.println("null: " + (isValidAadhaar(invalidAadhaar5) ? "Valid" : "Invalid"));
    }
}