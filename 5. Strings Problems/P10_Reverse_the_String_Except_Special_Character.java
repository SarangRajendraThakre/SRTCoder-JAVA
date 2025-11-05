public class P10_Reverse_the_String_Except_Special_Character {

    private static boolean isSpecial(char c) {
        return c == '@' || c == '$' || c == '-';
    }
 
    // public static String reverseStringWithExceptions(String s) {
      

    //     char[] chars = s.toCharArray();

    //     int left = 0;
    //     int right = chars.length - 1;

    //     while (left < right) {

    //         if (isSpecial(chars[left])) {
    //             left++;
    //             continue;
    //         }

    //         if (isSpecial(chars[right])) {
    //             right--;
    //             continue;
    //         }

    //         char temp = chars[left];
    //         chars[left] = chars[right];
    //         chars[right] = temp;

    //         left++;
    //         right--;
    //     }

    //     return new String(chars);
    // }



    public static String reverseStringAndCheck(String s)
    {
        int left = 0 ;
        int right = s.length()-1;

        char[] chars = s.toCharArray();

         while (left < right) {

            if(isSpecial(chars[left]))
            {
                left++;
            }
            if(isSpecial(chars[right]))
            {
                 right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;

        
         }
         return new String(chars);
    }

  

    public static void main(String[] args) {
        String inputString = "he@ll$o-world";
        String reversedString = reverseStringAndCheck(inputString);

        System.out.println("Original String: " + inputString);
        System.out.println("Reversed String: " + reversedString);

    }
}