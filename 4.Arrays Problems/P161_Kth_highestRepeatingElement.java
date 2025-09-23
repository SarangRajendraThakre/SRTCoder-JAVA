
import java.util.Arrays;
public class P161_Kth_highestRepeatingElement {

    public static void main(String[] args) {
        // Your code here


        int[] arr = {4, 5, 5, 2, 2, 2, 8, 8, 8, 8, 1};

        boolean[] visited = new boolean[arr.length];
       
        int k = 0;
        int[] frequency = new int[arr.length*2];

        for(int i = 0 , cnt = 1 ;i<arr.length ;i++,cnt=1)
        {
            if(visited[i]) continue;

            for(int j = i+1;j<arr.length;j++)
            {
                if(arr[i] == arr[j] && !(visited[j]))
                {
                    visited[j] = true;
                    cnt++;

                }
            }
            if(cnt > 0)
              {
                frequency[k++] = arr[i];
                frequency[k++] =  cnt;

              }
        }
        System.out.println(Arrays.toString(frequency));



        for(int i = 0 ;i<frequency.length;i++)
        {
            if(i%2 ==0 )
            {
                
            }
        }



    }
}
