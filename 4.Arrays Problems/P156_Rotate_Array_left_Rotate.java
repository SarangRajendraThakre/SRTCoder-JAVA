
public class P156_Rotate_Array_left_Rotate {

    public static void main(String[] args) {
        // Your code here


        int[] arr = {1,2,3,4,5,6,7};

        rotateArr(arr , 2);

        
    }


    public static  void rotateArr(int[] arr , int times)
    {
        for(int i = 0 ;i<times;i++)
        {
            int temp = arr[arr.length-1];
            for(int  j = arr.length -2 ;j>= 0 ;j--)
            {
                arr[j+1] = arr[j];

            }
            arr[0] = temp;
        }
        System.out.println(java.util.Arrays.toString(arr));
    }
}
