
public class P21_Str_Palindrome_Two_pointer_Approach1 {

    public static void main(String[] args) {
         

        System.out.println("Enter a String");
        String str = new java.util.Scanner(System.in).nextLine();
       
        System.out.println(
            isPalindrome(str)?str+" is Palindrome":str+" is not palindrome"
        );
    }
          
    public static boolean isPalindrome(String str)
    {
        str = str.replaceAll("[^A-Za-z]", "");
        int left = 0 ;
        int right = str.length()-1;
         while (left < right) {
            if(str.charAt(left++)!=str.charAt(right--))
              return false;
            
         }
         return true;

    }
    


}
