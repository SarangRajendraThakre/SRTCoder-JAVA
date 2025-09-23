import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P80_Str_Regex_Flag_Use1{

    public static void main(String[] args) {


        String str = "java is a prog lang java was created by sun JAVA is HLL";

        Pattern pattern = 
        Pattern.compile("java",Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(str);

        System.out.println("main String : "+str);

        System.out.println("regex" + pattern.toString());

        while (matcher.find()) {
            
            System.out.println(
                matcher.start()+" : "+matcher.end()+" - "+matcher.group()
            );
        }
        
    }
}
