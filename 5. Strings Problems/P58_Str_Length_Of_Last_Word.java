import java.util.Scanner;

public class P58_Str_Length_Of_Last_Word {

    public static void main(String[] args) {


         Scanner sc = new Scanner(System.in);

         String str = sc.nextLine();

         str.trim();

         int cnt = 0 ;

         for(int i=str.length()-1;i>=0;i-- )
         {
              
             if((str.charAt(i)==' ') )
                 {
                          
                    cnt = str.length()-1-i;
                     break;

                 }
                
                

         }
         System.out.println(cnt);




    }
}
