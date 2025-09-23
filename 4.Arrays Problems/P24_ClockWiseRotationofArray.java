import java.util.Arrays;
import java.util.Scanner;

public class P24_ClockWiseRotationofArray {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        System.out.println("Before"+Arrays.toString(arr));
        System.out.println("Enter the no of rotations : ");
        int rotations = new Scanner(System.in).nextInt();
        clockwiseRotation(arr , rotations);
        System.out.println(Arrays.toString(arr));
    }

    // public static void clockwiseRotation (int [] arr , int rotations)
    // {
    //     for(int i = 1 ;i<=rotations ; i++)
    //     {
    //         int temp = arr[arr.length-1];
    //         for(int j = arr.length-2 ;j>=0 ;j--)
    //         {
    //             arr[j+1] = arr[j];
    //         }
    //         arr[0] = temp;
    //     }

    // }



    public static void clockwiseRotation(int[] arr , int rotations)
    {
        for( int i = 1;i<= rotations ;i++)
        {
            int temp = arr[arr.length-1];
             for(int j = arr.length -2;j >=0;j--)
             {
                arr[j+1] = arr[j];
             }
             arr[0] =  temp;
        }
    }
}