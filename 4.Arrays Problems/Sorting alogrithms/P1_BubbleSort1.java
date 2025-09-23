import java.util.Arrays;

public class P1_BubbleSort1 {

    public static void main(String[] args) {

     
        
        int[] arr  = {2,5,6,3,7,4};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("------After  Bubble sorting --------");
        System.out.println(Arrays.toString(arr));

    }


    public static void bubbleSort(int [] arr)
    {
        for( int i = 0 ;i<arr.length ;i++)
        {
            for( int j = 0 ;j<arr.length - i -1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                     arr[j]  = arr[j+1];
                     arr[j+1] = temp;
                }
            }
        }
        
    }

   
    
}


// https://gemini.google.com/app/eeb2644dc73ffd4a




