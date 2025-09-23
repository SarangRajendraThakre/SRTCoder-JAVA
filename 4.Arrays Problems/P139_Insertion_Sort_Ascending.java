
public class P139_Insertion_Sort_Ascending {

    public static void main(String[] args) {
        // Your code here

        int[] arr = { 10, 50, 30, 343, 43, 5, 4, 34 };


        for( int i = 1 ;i<arr.length ;i++)
        {
           int prevIndex =  i - 1;
           int currentEle =  arr[i];

           while ( prevIndex >=0 && arr[prevIndex] > currentEle ) {
                
            arr[prevIndex+1] = arr[prevIndex];
                
                   
                prevIndex--;
           }
           arr[prevIndex +1 ] = currentEle;

        }




    

        System.out.println(java.util.Arrays.toString(arr));

    }
}
