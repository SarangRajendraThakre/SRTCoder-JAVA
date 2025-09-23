
import java.util.regex.*;
public class P94_Str_PhoneNo_Validation {


    public static void main(String[] args) {
        // String str = "+91 8022864491";
        String str = "919975558296";

        
        String invalidStr = "9154844"; 

        if (isValidPhoneNoValidation(str)) {
            System.out.println(str + " is a valid Phone number");
        } else {
            System.out.println(str + " is not a valid Phone number");
        }

        if (isValidPhoneNoValidation(invalidStr)) {
            System.out.println(invalidStr + " is a valid Phone number ");
        } else {
            System.out.println(invalidStr + " is not a valid Phone number ");
        }
    }

            String str = "+91 8022864491";
        String str1 = "919975558296";
    public static boolean isValidPhoneNoValidation(String str) {
        String regex = "^\\+?91[ ]?[0-9]{10}$";
        

        return Pattern.matches(regex , str);
  
    }
}