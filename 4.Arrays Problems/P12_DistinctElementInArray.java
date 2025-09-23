import java.util.Arrays;

public class P12_DistinctElementInArray {

    public static void main(String[] args) {
        
           int[] arr = {2, 34, 5, 5, 2, 8, 5}; 
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
            if(cnt>0)
            {
                System.out.println(arr[i]+" : "+cnt);
            }
        }
    }
    
}
