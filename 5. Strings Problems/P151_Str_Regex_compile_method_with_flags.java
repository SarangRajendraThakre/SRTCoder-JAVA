import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P151_Str_Regex_compile_method_with_flags {

    public static void main(String[] args) {

        System.out.println("________________CASE_INSENSITIVE________________");
        // Matches "java" regardless of case
        Pattern p1 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher m1 = p1.matcher("I love JAVA programming.");
        System.out.println("Case-Insensitive match found: " + m1.find()); // Output: true

        System.out.println("________________MULTILINE________________");
        // '^' and '$' match the start and end of each line
        String multilineText = "Line one\nLine two\nLine three";
        Pattern p2 = Pattern.compile("^Line", Pattern.MULTILINE);
        Matcher m2 = p2.matcher(multilineText);
        System.out.println("Multiline matches:");
        while (m2.find()) {
            System.out.println("  - " + m2.group());
        }

        System.out.println("________________DOTALL________________");
        // '.' matches any character, including line terminators
        String dotallText = "Hello\nworld";
        Pattern p3 = Pattern.compile("Hello.world", Pattern.DOTALL);
        Matcher m3 = p3.matcher(dotallText);
        System.out.println("Dotall match found: " + m3.find()); // Output: true

        System.out.println("________________COMMENTS________________");
        // Ignores whitespace and '#' comments
        String regexWithComments = "a # Match the character 'a'\n"
                + "b # Match the character 'b'\n"
                + "c # Match the character 'c'";
        Pattern p4 = Pattern.compile(regexWithComments, Pattern.COMMENTS);
        System.out.println("Comments flag match ('abc'): " + p4.matcher("abc").matches()); // Output: true

        System.out.println("________________LITERAL________________");
        // Treats the entire pattern string as a literal sequence, disabling
        // metacharacters
        String literalText = "Price is $10.00";
        Pattern p5 = Pattern.compile("$10.00", Pattern.LITERAL);
        Matcher m5 = p5.matcher(literalText);
        // System.out.println("Literal flag match found: " + m5.find()); // Output: true

        System.out.println("________________UNICODE_CASE________________");
        // Used with CASE_INSENSITIVE for full Unicode case folding
        // This is necessary for some languages with complex casing rules
        String unicodeText = "straße"; // German for street
        Pattern p6 = Pattern.compile("STRASSE", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m6 = p6.matcher(unicodeText);
        System.out.println("Unicode match found: " + m6.find()); // Output: true
    }
}