


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P83_Str_RegexNumberFinder {

    public static void main(String[] args) {
        // The string we want to search
        String text = "asd23usadf32a d4rqh544h";

        // The regex pattern to find sequences of one or more digits (\d+)
        String regex = "\\d+";

        System.out.println("Searching for numbers in the string: \"" + text + "\"");
        System.out.println("Using the regex pattern: " + regex);
        System.out.println("------------------------------------");

        // 1. Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // 2. Create a matcher object to apply the pattern to the text
        Matcher matcher = pattern.matcher(text);

        // 3. Find and print all matches
        int matchCount = 0;
        while (matcher.find()) {
            // matcher.group() returns the found sequence
            System.out.println("Found match: " + matcher.group());
            matchCount++;
        }

        if (matchCount == 0) {
            System.out.println("No matches found.");
        }
    }
}