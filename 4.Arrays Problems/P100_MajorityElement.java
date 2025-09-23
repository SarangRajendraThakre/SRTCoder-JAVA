
public class P100_MajorityElement {

    public static void main(String[] args) {

        int[] arr = {2,3,4,5,6,7,4,8,4,9,3,4};
 
        majorityElements(arr);

      
    }
      public static void majorityElements( int[] arr)
        {
            String  str = "";
            int  MajoritySize = arr.length / 3;

                boolean[] visited = new boolean[arr.length];

            for(int i =  0 ,cnt=1;i<arr.length ;i++ , cnt=1)
            {

                if(visited[i]) continue;

                for(int j = i+1;j<arr.length ;j++)
                {
                    if(arr[i]==arr[j] && !(visited[j]))
                    {
                        visited[j] = true;
                        cnt++;
                    }
                }
                if(cnt >= MajoritySize)
                {
                    str+=arr[i]+" ";
                }
            }
            System.out.println( java.util.Arrays.toString(str.split(" ")));

       
            

        }
}
