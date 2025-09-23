
// public String(StringBuffer sb)
public class P112_String_Constructor {

    public static void main(String[] args) {
         StringBuffer buffer = new StringBuffer("Java");
        buffer.append(" is");
        buffer.append(" fun!");

        // Use the constructor to convert the StringBuffer to a String
        String finalString = new String(buffer);

        System.out.println("The final String is: " + finalString);


    }
}
