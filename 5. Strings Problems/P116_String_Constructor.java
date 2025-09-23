
//   public String(byte[] bytes)
public class P116_String_Constructor {

    public static void main(String[] args) {
         byte[] bytes = {72, 101, 108, 108, 111};

        // This creates a string using the default charset
        String myString = new String(bytes);

        System.out.println("The resulting string is: " + myString);
    }
}
