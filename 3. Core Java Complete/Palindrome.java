public class Palindrome {

    public static void main(String[] args) {
        

        int rev = 0 ;
        int rem = 0;
        int num = 0 ;
        
 
        for( num = 1234 ; num > 0 ; num /= 10)
        {
 
          rem = num % 10 ;
         rev = rev * 10 + rem;

         if(num ==0 )
         {
            String ans =  (rev == num)?("it is palindrome"):("it is not a palindrome");
 
            System.out.println(rev);
            System.out.println(ans);

         }
        }

      


    }
    
}
