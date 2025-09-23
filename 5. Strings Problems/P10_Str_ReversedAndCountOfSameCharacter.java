
public class P10_Str_ReversedAndCountOfSameCharacter {


    public static String reverse(String str)
    {
        char[] charString = str.toCharArray();
        int left  =0 ;
        int right = str.length()-1;

        while(left < right)
        {
        char ch = charString[left];
            charString[left]=charString[right];
            charString[right] = ch;
            left++;
            right--;
        }
        return new String(charString);
    }
    public static void main(String[] args) {


        String str = "sarag";
        String str2 = "sarang";       
        
        String reversedString=  reverse(str2);
        
     
        int cnt =0;
        System.out.println(str);
        System.out.println(reversedString);

         for(int i = 0 ;i<str.length();i++)
         {

             if(str.charAt(i) == str2.charAt(i))
             {
                cnt++;
             }
         }

         System.out.println(cnt);

      
    }
}
