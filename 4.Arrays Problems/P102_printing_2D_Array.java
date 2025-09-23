
public class P102_printing_2D_Array {

    public static void main(String[] args) {
        // Your code here


        int[][]  array_2d = {{2,3,55,43},{43,56,464}};

        System.out.println("for loop");

        // using for loop 
        for(int i =0 ;i<array_2d.length;i++)
        {
             for( int j =0 ;j< array_2d[i].length ;j++ )
             {
                System.out.print(array_2d[i][j]+" ");
             }
        }
        System.out.println();

        // using while-loop
        System.out.println("using while loop");


        int ii=0; int jj = 0;
        while ( ii  < array_2d.length   ) {

            while (jj < array_2d[ii].length) {
                 
            System.out.print(array_2d[ii][jj]+" ");
       
            jj++;
                
            }
                 ii++;
                 jj=0;
            
        }

        // using  do while-loop
        System.out.println();
        System.out.println("using do  while loop");


        int iii=0; int jjj = 0;
        do{
            do
            {
                System.out.print(array_2d[iii][jjj]+" ");
            jjj++;
            }
            while( jjj < array_2d[iii].length );
            iii++;
            jjj=0;

           

        }
        while(iii < array_2d.length  );
      






    }
}
