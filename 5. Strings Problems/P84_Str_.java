import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P84_Str_ {

    public static void main(String[] args) {

        String str = "ABC676afds5j3453jdsf";
        Pattern pattern = Pattern.compile("[0-9]");
        // Pattern pattern  = Pattern.compile("[0-9]+");
        Matcher mt = pattern.matcher(str);

        while (mt.find()) {
            System.out.println(mt.group(0));
            
        }
        
    }
}
