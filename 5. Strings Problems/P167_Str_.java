
public class P167_Str_ {

    public static void main(String[] args) {
        // Your code here

        String str = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(str));

    }

    public static boolean isPalindrome(String str)
    {

        String s = "";
        String t = "";
        str.toLowerCase().trim();

        for(int i = str.length()-1;i>=0;i--)
        {

            if((str.charAt(i) >= 97 && str.charAt(i) <= 122 ) )
                s+=str.charAt(i);
        }
         for(int i = 0 ;i <str.length() ;i++)
        {
            
            if( (str.charAt(i) >= 97 && str.charAt(i) <= 122 ) )
                t+=str.charAt(i);
        }
        if(s.equals(t)) return true ;
    
        return false;

    }
}
