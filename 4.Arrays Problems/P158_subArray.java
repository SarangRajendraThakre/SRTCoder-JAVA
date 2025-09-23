
public class P158_subArray {

    public static void main(String[] args) {
        // Your code here

        int[] arr = {1,2,3,4,56,7,8,9};

        subArray(arr, 3,5);

    }
    public static void subArray(int[] arr , int start , int end)
    {
        int[] newArr = new int [end - start];
        for(int i = start , j = 0 ;i<end;i++,j++)
        {
            newArr[j] = arr[i];
        }
        System.out.println(java.util.Arrays.toString(newArr));
    }
}
