import java.util.Arrays;
import java.util.Scanner;

public class P25_AntiClockWiseRotationofArray {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        System.out.println("Before"+Arrays.toString(arr));
        System.out.println("Enter the no of rotations : ");
        int rotations = new Scanner(System.in).nextInt();
        anticlockwiseRotation(arr , rotations);
        System.out.println(Arrays.toString(arr));
    }

    public static void anticlockwiseRotation (int [] arr , int rotations)
    {
        for(int i = 1 ;i<=rotations ; i++)
        {
          //  1,2,3,4,5,6
            int temp = arr[0];
         
            // for( int j = 1;j<arr.length ;j++)
            // {
            //     arr[j-1] = arr[j];

            // }

            for(int j = 0;j<arr.length -1 ;j++)
            {
               arr[j] = arr[j+1];
            }
            arr[arr.length-1] = temp;
        }

    }
}