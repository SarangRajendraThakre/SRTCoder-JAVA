
public class P106_Product_Of_1D_Array_Elements {

  public static void main(String[] args) {

        int[]  arr = {10,20,30};

        // using for loop
        System.out.println("using for loop");
        int sum =1;
        for( int i =0  ; i<arr.length ;i++)
        {
             sum *= arr[i];
        }
        System.out.println(sum);



        // using while-loop
        System.out.println();
        System.out.println("using while loop");
       int i =0 , sum1 = 1;
        while( i < arr.length)
        {
             sum1 *= arr[i];
            i++;
        }
        System.out.println(sum1);


        // using do while-loop
        System.out.println();
        System.out.println("using  do while loop");
       int ii = 0 , sum2 = 1 ;

        do
        {
            sum2  *= arr[ii];

            ii++;
        }
        while(ii < arr.length);
        System.out.println(sum2);

        // using for each loop
        System.out.println();
        System.out.println("using for each loop");
      
        int sum4 = 1;
        for( int ele :arr )
          sum4 *= ele;
        
          
        System.out.println(sum4);  
            







    }
}
