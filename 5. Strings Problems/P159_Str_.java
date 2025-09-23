import java.util.regex.*;

public class P159_Str_ {

    public static void main(String[] args) {

        Pattern p = Pattern.compile("is");
        Matcher m = p.matcher("This is a test.");

        // Use the matcher on the first string
        while (m.find()) {
            System.out.println("Found in first string at: " + m.start());
        }

        // Reset the matcher with a new input string
        m.reset("Is this a new test?");

        // Use the matcher on the new string
        while (m.find()) {
            System.out.println("Found in second string at: " + m.start());
        }
    }
}
