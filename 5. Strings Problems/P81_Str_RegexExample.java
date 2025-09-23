import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P81_Str_RegexExample {

    public static void main(String[] args) {


        String str = "JAVA is PL \n java is HLL \n "+
                     "JAVA is multi-threaded \n it support WORA JAVA";

        Pattern pattern =  Pattern.compile("^JAVA" , Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = pattern.matcher(str);

        System.out.println(str);

        while (matcher.find()) {
            System.out.println(matcher.group()+" : "+matcher.start()+" , "+matcher.end());
        }
        
    }
}
