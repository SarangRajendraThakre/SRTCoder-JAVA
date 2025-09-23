import java.util.Arrays;

public class P14_DuplicatesElementInArray {

    public static void main(String[] args) {
        
        int [] arr = {2,3,5,6,7,54,34,6  , 2};
        boolean [] b  =  new boolean[arr.length];
        System.out.println(Arrays.toString(arr));

        for(int  i = 0 ;i<arr.length ; i++)
        {
            int cnt = 0 ;
            for(int j = 0 ;j<arr.length ;j++ )
            {
                if(arr[i]==arr[j] && !b[j])
                {
                    cnt++;
                    b[j]=true;
                }
            }
            if(cnt > 1)
            {
                System.out.println(arr[i]+" : "+cnt);
            }
        }
    }
    
}
