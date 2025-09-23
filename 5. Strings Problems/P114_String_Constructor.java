
//  public String(char[] ch)
public class P114_String_Constructor {

    public static void main(String[] args) {

         char[] charArray = {'J', 'A', 'V', 'A', ' ', 'I', 'S', ' ', 'F', 'U', 'N'};

        String myString = new String(charArray);

        System.out.println("The new String is: " + myString);
    }
}
