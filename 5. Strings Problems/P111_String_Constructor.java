
//   public String(String str) 
public class P111_String_Constructor {

    public static void main(String[] args) {

        String original = "Hello, Java!";
        String copy = new String(original);

        System.out.println("Original string: " + original);
        System.out.println("Copied string: " + copy);
    }
}
