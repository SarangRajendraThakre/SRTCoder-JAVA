
public class P108_Product_of_2D_Array_Elements {
    public static void main(String[] args) {
        // Your code here

        int[][]  array_2d = {{2,3},{43,56}};

        System.out.println("for loop");

        // using for loop 
        int sum =1;
        for(int i =0 ;i<array_2d.length;i++)
        {
             for( int j =0 ;j< array_2d[i].length ;j++ )
             {
                  sum *= array_2d[i][j];
             }
        }
        System.out.println(sum);
        System.out.println();

        // using while-loop
        System.out.println("using while loop");


        int ii=0; int jj = 0; int sum1 =1;
        while ( ii  < array_2d.length   ) {

            while (jj < array_2d[ii].length) {
                 
           sum1 *= array_2d[ii][jj];
       
            jj++;
                
            }
                 ii++;
                 jj=0;
            
        }
        System.out.println(sum1);

        // using  do while-loop
        System.out.println();
        System.out.println("using do  while loop");


        int iii=0; int jjj = 0;int sum2 = 1;
        do{
            do
            {
                sum2 *= array_2d[iii][jjj];
            jjj++;
            }
            while( jjj < array_2d[iii].length );
            iii++;
            jjj=0;

           

        }
        while(iii < array_2d.length  );
        System.out.println(sum2);
      






    }
}
