import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P89_Str_EMAIL_Validation {

    public static void main(String[] args) {

        System.out.println("Enter the email No:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 3. Check the boolean result and print a message
        if (isPanCardValid(str)) {
            System.out.println("'" + str + "' is a valid email id format.");
        } else {
            System.out.println("'" + str + "' is an invalid email id ");
        }

        sc.close(); // Good practice to close the scanner
    }

    public static boolean isPanCardValid(String str) {
        // The regex is correct for PAN card format validation
        Pattern pattern = Pattern.compile("^[A-Za-z0-9.$-_]+@[A-Za-z.]+\\.[A-Za-z]{2,3}");
        Matcher mt = pattern.matcher(str);

        // 1. Perform the match
        boolean isValid = mt.matches();

        // 2. Return the boolean result
        return isValid;
    }
}