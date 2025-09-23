import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P82_Str_Validation {

    public static void main(String[] args) {


        String str = "ghs12se434agru5453";

        Pattern pt = Pattern.compile("[0-9]*");
        Matcher mt = pt.matcher(str);

        while (mt.find()) {

            System.out.println(mt.group()+" : "+mt.start()+" , "+mt.end());
            
        }


    }
}
 