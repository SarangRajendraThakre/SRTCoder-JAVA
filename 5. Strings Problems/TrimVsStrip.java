public class TrimVsStrip {
    public static void main(String[] args) {
        // The string now includes a standard space (\u0020), a thin space (\u2009),
        // and another standard space.
        String unicodeSpace = " " + "\u2009" + " ";

        // A string with leading and trailing Unicode spaces
        String text = unicodeSpace + "Sarang"+'\u2009' ;

        System.out.println("Original string: '" + text + "'");
        System.out.println("Original length: " + text.length());

        // Using trim()
        String trimmedString = text.trim();
        System.out.println("\nTrimmed string (removes <= U+0020): '" + trimmedString + "'");
        System.out.println("Trimmed length: " + trimmedString.length());

        // Using strip()
        String strippedString = text.strip();
        System.out.println("\nStripped string (removes all Unicode whitespace): '" + strippedString + "'");
        System.out.println("Stripped length: " + strippedString.length());

        // Using stripLeading()
        String strippedLeading = text.stripLeading();
        System.out.println("\nStripped leading: '" + strippedLeading + "'");
        System.out.println("Stripped leading length: " + strippedLeading.length());

        // Using stripTrailing()
        String strippedTrailing = text.stripTrailing();
        System.out.println("\nStripped trailing: '" + strippedTrailing + "'");
        System.out.println("Stripped trailing length: " + strippedTrailing.length());
    }
}