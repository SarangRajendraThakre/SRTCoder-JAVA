
public class P52_ {

    public static void main(String[] args) {
        // Your code here


        String str = "nitin";
       int start = str.length()-1;
       int end =0;
       String revop="";
        String rev =  palindrome( start ,str ,end,revop);
        System.out.println(rev);


    }

     public static  String palindrome( int start , String str , int end,String revop  )
     {
          
        if(start!=0) 
        return revop;
      
        revop= revop+str.charAt(start)+"";
        --start;
        ++end;
       
         return  palindrome(start, str, end,revop);
     }
    
}
