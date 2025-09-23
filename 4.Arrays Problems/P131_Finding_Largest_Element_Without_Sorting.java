
public class P131_Finding_Largest_Element_Without_Sorting {

    public static void main(String[] args) {
        // Your code here

        int[] arr = {10,20,30,50,60,70,540,30,50,420,402,4};

         int largest =  Integer.MIN_VALUE;
         for(int i =  1;i<arr.length ;i++)
         {
            if( arr[i]  >  largest)
            {
                largest = arr[i];
            }
         }
         System.out.println(largest);


    }
}
