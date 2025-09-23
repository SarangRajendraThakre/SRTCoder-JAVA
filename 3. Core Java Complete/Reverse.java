public class Reverse {

    public static void main(String[] args) {
        

      
       int rev = 0 ;
       int rem = 0;
       

       for(int num = 1234 ; num > 0 ; num /= 10)
       {

         rem = num % 10 ;
        rev = rev * 10 + rem;



       }

       System.out.println(rev);
       

       
    }
    
}
