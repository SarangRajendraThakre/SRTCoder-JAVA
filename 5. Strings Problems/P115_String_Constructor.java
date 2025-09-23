
// public String (char[] ch , int start , int count)
public class P115_String_Constructor{

    public static void main(String[] args) {
          char[] fullSentence = {'J', 'a', 'v', 'a', ' ', 'i', 's', ' ', 'p', 'o', 'w', 'e', 'r', 'f', 'u', 'l'};

        // We want to create a string from the word "powerful"
        // It starts at index 9 and has a length of 8 characters.
        int offset = 8;
        int count = 8;

        // Use the constructor to create a string from the specified portion
        String word = new String(fullSentence, offset, count);

        System.out.println("The original char array contains: " + new String(fullSentence));
        System.out.println("The new String from the subarray is: " + word);
  
    }
}
