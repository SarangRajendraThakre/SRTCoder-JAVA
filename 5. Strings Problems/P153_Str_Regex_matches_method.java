import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P153_Str_Regex_matches_method {

    public static void main(String[] args) {
        // Your code here


        // Pattern p = Pattern.compile('[0-9]+');
        Pattern p = Pattern.compile("[0-9]+");

        Matcher matcher = p.matcher("ABC123DEF456sdfk");

        while (matcher.find()) 
            System.out.println(matcher.group()+" : "+matcher.start() + " , "+matcher.end());
        
        
        
    }
}
