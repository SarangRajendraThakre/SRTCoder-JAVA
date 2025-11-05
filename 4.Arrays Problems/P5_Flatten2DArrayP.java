import java.util.Arrays;

public class P5_Flatten2DArrayP {


    public static void main(String[] args) {
        int[][] my2DArray = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7}};

                  flattenArray(my2DArray);
        }



    public static void flattenArray(int[][] arr2d){

        int count = 0;
        for(int i = 0;i<arr2d.length;i++)
        {
            for(int j = 0;j<arr2d[i].length;j++)
            {
                count++;

            }
        }
        
        int[] flatArray = new int[count];
        int k = 0;
        for(int i = 0;i<arr2d.length;i++)
        {
            for(int j = 0;j<arr2d[i].length;j++)
            {
                flatArray[k++]=arr2d[i][j];

            }

        }
        System.out.println(Arrays.toString(flatArray));
        


    }
   

}