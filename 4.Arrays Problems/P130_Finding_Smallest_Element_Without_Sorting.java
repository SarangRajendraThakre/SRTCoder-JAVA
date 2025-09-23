
public class P130_Finding_Smallest_Element_Without_Sorting {

    public static void main(String[] args) {
        // Your code here

        int[] arr = {10,20,30,50,60,70,540,30,50,420,402,4};

         int smallest = Integer.MAX_VALUE;
         for(int i =  1;i<arr.length ;i++)
         {
            if( arr[i] < smallest)
            {
                smallest = arr[i];
            }
         }
         System.out.println(smallest);


    }
}
