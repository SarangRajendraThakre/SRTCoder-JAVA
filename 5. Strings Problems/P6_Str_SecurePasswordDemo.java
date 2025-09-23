


import java.util.Arrays;

public class P6_Str_SecurePasswordDemo {

    public static void main(String[] args) {

        // 1. Store the password in a char array
        char[] password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

        System.out.println("Original password: " + new String(password));

        // 2. Erase the password from memory for security
        // This is the action you asked about.
        Arrays.fill(password, '0');

        // 3. Attempt to print the "cleared" password
        // The output will be "00000000" because the original data is gone.
        System.out.println("Password after clearing: " + new String(password));

        // 4. In a real application, you would make the array eligible for garbage collection
        password = null;
    }
}