
public class P168_ {

    public static void main(String[] args) {
        // Your code here

        int[][] arr  =  {{2,3,4},{54,4,344}};

        // for(int i = 0 ;i<arr.length;i++)
        // {
        //     for(int j = 0 ;j<arr[i].length;j++)
        //     {
        //         System.out.println(arr[i][j]);
        //     }
        // }


        int i = 0 , j =0;
        while(i < arr.length)
        {

            while (j < arr[i].length) {
                System.out.println(arr[i][j]);
                j++;
            }
            i++;
            j = 0;


        }



    }
}
