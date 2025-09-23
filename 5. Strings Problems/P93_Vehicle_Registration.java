import java.util.regex.*;

public class P93_Vehicle_Registration {

    public static void main(String[] args) {
        String str = "MH32 AM 7553";
        String str1 = "MH32AM7553";

        
        String invalidStr = "SAS32 AM 7553"; 

        if (isValidVehicleNo(str)) {
            System.out.println(str + " is a valid Vehcile number");
        } else {
            System.out.println(str + " is not a valid Vehcile number");
        }

        if (isValidVehicleNo(invalidStr)) {
            System.out.println(invalidStr + " is a valid Vehcile number ");
        } else {
            System.out.println(invalidStr + " is not a valid Vehcile number ");
        }
    }

   
    public static boolean isValidVehicleNo(String str) {
        String regex = "^[A-Z]{2}[0-9]{2}[ ]?[A-Z]{2}[ ]?[0-9]{4}";
        
        return Pattern.matches(regex, str);
    }
}