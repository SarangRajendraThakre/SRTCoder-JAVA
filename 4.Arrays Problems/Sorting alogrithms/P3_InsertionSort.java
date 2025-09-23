import java.util.Arrays;

public class P3_InsertionSort {

    
     public static void main(String[] args) {

        int[] arr  = {2,5,6,3,7,4};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("------After  Insertion sorting --------");
        System.out.println(Arrays.toString(arr));

    }

     public static void insertionSort(int [] arr)
     {
        for(int i = 1 ;i<arr.length;i++)
        {
          int currentEle = arr[i];
          int prevIndex  = i - 1; 
            
          while ( prevIndex >= 0 && arr[prevIndex] > currentEle) {
            
                arr[prevIndex+1] = arr[prevIndex];
                prevIndex--;
          }
             arr[prevIndex+1] =  currentEle;
        }
     }

   

}

// https://gemini.google.com/app/07e95fc232b88cff