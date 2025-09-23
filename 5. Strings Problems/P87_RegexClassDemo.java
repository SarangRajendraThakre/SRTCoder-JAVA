import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  P87_RegexClassDemo {

    public static void main(String[] args) {
        String text = "The quick brown fox 99 jumps$ over@ the 7 lazy dogs!";

        System.out.println("--- Testing on String: \"" + text + "\" ---");

        // 1. The Dot (.) - Any Character
        demonstrateRegex("Any Character (.)", "..o", text);

        // 2. Shorthand Classes (\d, \w, \s)
        demonstrateRegex("Digits (\\d)", "\\d*", text);
        demonstrateRegex("Word Characters (\\w)", "\\w", text);
        demonstrateRegex("Whitespace (\\s)", "\\s", text);

        // 3. Negated Shorthand Classes (\D, \W, \S)
        demonstrateRegex("Non-Digits (\\D)", "\\D", text);
        demonstrateRegex("Non-Word Characters (\\W)", "\\W", text);
        demonstrateRegex("Non-Whitespace (\\S)", "\\S", text);

        // 4. Custom Character Classes [ ]       
        demonstrateRegex("Custom Set [bg]", "[sar]", text);
        demonstrateRegex("Range [a-e]", "[a-e]", text);
        demonstrateRegex("Negated Set [^a-z]", "[^a-z]", text); // Finds non-lowercase letters
    }

  
    public static void demonstrateRegex(String description, String regex, String text) {
        System.out.println("\n--- " + description + " | Pattern: " + regex + " ---");
        
        // Compile the pattern and create a matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Find and print all matches
        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            found = true;
        }

        if (!found) {
            System.out.print("No matches found.");
        }
        System.out.println(); // for a new line
    }
}