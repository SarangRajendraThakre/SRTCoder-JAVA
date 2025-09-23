
public class P105_Sum_Of_1D_Array_Elements {
    public static void main(String[] args) {

        int[]  arr = {10,20,30,40,50,60,70,80,90};

        // using for loop
        System.out.println("using for loop");
        int sum =0;
        for( int i =0  ; i<arr.length ;i++)
        {
             sum += arr[i];
        }
        System.out.println(sum);

        // using while-loop
        System.out.println();
        System.out.println("using while loop");
       int i =0 , sum1 = 0;
        while( i < arr.length)
        {
             sum1 += arr[i];
            i++;
        }
        System.out.println(sum1);


        // using do while-loop
        System.out.println();
        System.out.println("using  do while loop");
       int ii = 0 , sum2 = 0 ;

        do
        {
            sum2+= arr[ii];

            ii++;
        }
        while(ii < arr.length);
        System.out.println(sum2);

        // using for each loop
        System.out.println();
        System.out.println("using for each loop");
      
        int sum4 = 0;
        for( int ele :arr )
          sum4 += ele;
        
          
        System.out.println(sum4);  
            







    }
}
