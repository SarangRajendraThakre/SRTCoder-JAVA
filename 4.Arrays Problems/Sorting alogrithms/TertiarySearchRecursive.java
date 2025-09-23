import java.util.Arrays;

public class TertiarySearchRecursive {
    

    public static void main(String[] args) {

         int[] arr = new int[20];

         for(int i =0 , j=0;i<arr.length;i++  ,j+=10)
         {
            arr[i] = j;
         }
         int key = 90;

         System.out.println( "Before  "+ Arrays.toString(arr) );
 int left = 0 ;
    int right = arr.length - 1;
    int mid1  = left + (right - left)/2 ;
    int mid2 = right - (right - left)/2;

     int  pos =    ternarySearch(arr , key , left , right , mid1 , mid2 );
     System.out.println(pos);


}


public static int ternarySearch(int []arr , int key  , int left , int right ,  int mid1 , int mid2 )
{
   
    while (left <= right) {

        if( arr[mid1] == key ) { return mid1; }
        if( arr[mid2] == key ) { return mid2;   }
        if(key < arr[mid1]){   ternarySearch(arr, key, left, mid1-1, mid1, mid2 );};
        if(key > arr[mid2]){ ternarySearch(arr, key, mid2+1, right, mid1, mid2); } 
        if( key > arr[mid1] && key < arr[mid2])
        {
             ternarySearch(arr, key , mid1+1 , mid2-1, mid1, mid2);
        }
       
        
    }

    return -1;



}

}