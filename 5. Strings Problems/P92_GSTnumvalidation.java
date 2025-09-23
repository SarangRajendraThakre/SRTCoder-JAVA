import java.util.regex.*;

public class P92_GSTnumvalidation {

    public static void main(String[] args) {
        String str = "27ABCDE1234F1Z5";
        
        String invalidStr = "27ABCDE3456Z4Z"; 

        if (isValidGstNo(str)) {
            System.out.println(str + " is a valid GST number");
        } else {
            System.out.println(str + " is not a valid GST number");
        }

        if (isValidGstNo(invalidStr)) {
            System.out.println(invalidStr + " is a valid GST number ");
        } else {
            System.out.println(invalidStr + " is not a valid GST number ");
        }
    }

   
    public static boolean isValidGstNo(String str) {
        String regex = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[A-Z0-9]{1}Z[A-Z0-9]{1}$";
        
        return Pattern.matches(regex, str);
    }
}