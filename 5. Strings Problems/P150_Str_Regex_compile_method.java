import java.util.regex.*;

public class P150_Str_Regex_compile_method {
    public static void main(String[] args) {
        // Your code here

        Pattern p =  Pattern.compile("[abc]+");
        Matcher m = p.matcher("abc");

        Matcher m2 = p.matcher("abcadeabcghi");
        Matcher m3 = p.matcher("abcabcabc");

        System.out.println("------1--------");
        System.out.println(m.matches());
        System.out.println("------2-------");
        System.out.println(m2.matches());
        System.out.println("------3------");
        System.out.println(m3.matches());
    }
}
