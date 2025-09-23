
public class P10_Str_ReversedAndCountOfSameCharacterWithStringBuilder {

    public static void main(String[] args) {


        String str = "sarag";

        StringBuilder sb = new StringBuilder(str);

        sb.reverse();
        int cnt =0;
        System.out.println(str);
        System.out.println(sb.toString());

         for(int i = 0 ;i<str.length();i++)
         {

             if(str.charAt(i) == sb.charAt(i))
             {
                cnt++;
             }
         }

         System.out.println(cnt);

      
    }
}
