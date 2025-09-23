import java.util.Arrays;

public class P7_SeparatePositiveNegativeNo {


    public static void main(String[] args) {
        
        int [] arr = {3,23,-5,-65,0,5,57,74,-66};

        System.out.println(Arrays.toString(arr));

        for(int i = 0 ;i<arr.length ;i++)
        {
            if(arr[i] < 0 )
            {
                for(int j = i+1 ;j < arr.length ;j++)
                {
                    if(arr[j] >= 0)
                    {
                        int temp = arr[i];
                        arr[i]  = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

        System.out.println("-------After Separating into Positive and negative ---------------");

        System.out.println(Arrays.toString(arr));


    }






}