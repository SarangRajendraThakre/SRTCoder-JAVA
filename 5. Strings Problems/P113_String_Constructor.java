
// public String(StringBuilder sb)
public class P113_String_Constructor{

    public static void main(String[] args) {
         StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append(" ");
        builder.append("World");

        // Use the constructor to convert the StringBuilder to an immutable String
        String finalString = new String(builder);

        System.out.println("The final String is: " + finalString);
    }
}
