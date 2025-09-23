
public class P136_Bubble_Sort_Descending {

    public static void main(String[] args) {
        // Your code here

             int[] arr = {10,50,30};

             for(int i = 0 ;i<arr.length ;i++)
             {
                 for( int j = 0 ;j<arr.length-1-i;j++)
                 {
                    if(arr[j]  < arr[j+1] )
                    {
                        int temp = arr[j];
                        arr[j]  = arr[j+1];
                        arr[j+1] = temp;
                    }
                 }
             }

             System.out.println( java.util.Arrays.toString(arr));




    }
}
