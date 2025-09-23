import java.util.Arrays;

public class TertiarySearch {
    

    public static void main(String[] args) {

         int[] arr = new int[20];

         for(int i =0 , j=0;i<arr.length;i++  ,j+=10)
         {
            arr[i] = j;
         }
         int key = 90;

         System.out.println( "Before  "+ Arrays.toString(arr) );

         ternarySearch(arr , key);


}


public static void ternarySearch(int []arr , int key)
{
    int left = 0 ;
    int right = arr.length - 1;
    int mid1  = left + (right - left)/2 ;
    int mid2 = right - (right - left)/2;

    while (left <= right) {

        if( arr[mid1] == key ) {System.out.println("Key found at : "+mid1); break;}
        if( arr[mid2] == key ) {System.out.println("Key found at : "+mid2); break;}
        if(key < arr[mid1]){  right = mid1-1;}
        if(key > arr[mid2]){  left = mid2+1;}
        if( key > arr[mid1] && key < arr[mid2])
        {
            left = mid1 + 1;
            right = mid2 -1;
     
        }
       
        
    }



}

}