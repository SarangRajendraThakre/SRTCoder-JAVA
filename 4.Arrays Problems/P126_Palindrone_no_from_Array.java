
public class P126_Palindrone_no_from_Array {

    public static void main(String[] args) {
        // Your code here

         int [] arr = { 4,4,5,6,7,6,8,97,4,545,5,45,4,153 , 121,1331};

         int []  palidromeArray = new int[arr.length];
 
         int i  = 0 ;
         for( int ele : arr)
         {
             if(isPalindrome(ele) && ele > 10)
             {
                 palidromeArray[i++] = ele;
                 
             }

         }
         System.out.println(java.util.Arrays.toString(palidromeArray));


    }
    public static boolean isPalindrome (int no)
    {
        
        int  temp = no;
         int rem = 0 ;
         while (no> 0 ) 
         {
            rem = rem * 10 + no % 10 ;
         no /= 10;        
         }
         if( temp == rem)
         {
            return true;
         }
         return false;
        
    }
}
