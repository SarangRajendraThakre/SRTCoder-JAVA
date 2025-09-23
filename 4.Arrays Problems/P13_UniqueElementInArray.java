import java.util.Arrays;

public class P13_UniqueElementInArray {

    public static void main(String[] args) {
        
           int[] arr = {2, 34, 5, 5, 2, 8, 5}; 
        boolean [] b  =  new boolean[arr.length];
        System.out.println(Arrays.toString(arr));

        for(int  i = 0 ;i<arr.length ; i++)
        {
            int cnt = 0 ;
            for(int j = i+1;j<arr.length ;j++ )
            {
                if(arr[i]==arr[j] && !b[j] )
                {
                    cnt++;
                    b[j]=true;
                }
            }
            if(cnt == 1)
            {
                System.out.println(arr[i]+" : "+cnt);
            }
        }
    }
    
}
