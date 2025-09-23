
public class P151_zeros_To_one_End {

    public static void main(String[] args) {
        // Your code here

        int[] arr = {34,5,6,5045,6,0,405,0};

        for(int i =0 ;i<arr.length ;i++)
        {
            if(arr[i] == 0 )
            {
                for(int j = i+1 ;j< arr.length ;j++)
                {
                    if(arr[j]!=0)
                    {
                      int temp =  arr[j];
                         arr[j] = arr[i];
                         arr[i] = temp;
                    }
                }
            }
        }
        System.out.println(java.util.Arrays.toString(arr));
    }
}
