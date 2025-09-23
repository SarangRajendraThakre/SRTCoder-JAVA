
import java.util.*;
public class P148_Next_Permutation_Of_Array {

    public static void main(String[] args) {
        // Your code here

        int[] arr = { 1, 5, 8, 4, 7, 6, 5, 3, 1 };
   


        for(int i = arr.length ;i>= 0 ;i--)
        {

            int right = arr[i];
            if(arr[i-1] < arr[i]  )
            {
                int pivot = arr[i-1];
                
              Arrays.copyOfRange(arr, 0, i-2) ;  
               Arrays.sort(swap(pivot , arr) , i , arr.length);
                return;
            }
            

        }

    }
    public static int[]  swap ( int pivot , int [] arr)
    {
        
        int number = arr[pivot];
           Arrays.sort(arr , pivot  , arr.length );

          

    }
}
