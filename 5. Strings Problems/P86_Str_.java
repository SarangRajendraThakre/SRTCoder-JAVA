import java.util.Scanner;

public class P86_Str_ {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

         System.out.println("Enter the String : ");
         String str = sc.nextLine();

         System.out.println("Enter the String which need to check  : ");
         String  rotatedString =  sc.nextLine();


         isRotatedString(str , rotatedString);

    }

    public static void isRotatedString(String str , String rotatedString)
    {
          char[] charArray = str.toCharArray();

          String s = "";
          

          for( int j = 0 ;j<charArray.length-1;j++)
          {
            char temp =  charArray[charArray.length-1];
                  for(int i =charArray.length-2 ;i>=0;i--)
               {
                    charArray[i+1] = charArray[i];
             

                 }
                 charArray[0]=temp;
                String str1 = new String(charArray);
                s+= str1+" ";

                // System.out.println(s);
                

   
          }

          System.out.println(isPresent(s , rotatedString));


        
   
        }
        public static boolean isPresent(String s , String rotatedString)
        {
             String[] words = s.split(" ");
             for(String word : words)
             {
                if(word.equals(rotatedString))
                {
                    return true;
                }
                
             }return false;

        }

}
