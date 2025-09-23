import java.util.Arrays;

public class P7_SeparatePositiveNegative {



    public static void main(String[] args) {
        
        int [] arr = {3,23,5,65,5,57,74,-65,-66};

        int left = 0 ;
        int right = arr.length -1;

        while (left <= right) {
            
            if(arr[left] < 0 )
            {
                if(arr[right] > 0)
                {
                    int temp = arr[right];
                    arr[right] = arr[left];
                    arr[left] = temp;
                    left++;
                    right--;
                }
                else{
                    right--;
                }

            }
            else{
                left++;
            }
        }

           System.out.println(Arrays.toString(arr));

    }






}