import java.util.Arrays;

public class P23_SecondHighestRepeatingElement {

    public static void main(String[] args) {
        
        int [] arr = {1, 2, 3, 4, 1, 2, 3, 5, 3, 5, 6, 7, 8, 9, 10, 12};
        boolean [] b  =  new boolean[arr.length];
        System.out.println(Arrays.toString(arr));

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int temp1 = 0 ;
        int temp2 = 0 ;


        for(int  i = 0 , cnt=1 ;i<arr.length ; i++ , cnt=1)
        {
            if(b[i]) continue;

          
            for(int j = i+1 ;j<arr.length ;j++ )
            {
                if(arr[i]==arr[j] && !b[j])
                {
                    cnt++;
                    b[j]=true;
                }
            }

              if(cnt>max1) 
              {
                    max2 = max1;
                    max1 = cnt; 
                    temp2 = temp1;
                    temp1 = arr[i];
              }





            
                System.out.println(arr[i]+":"+cnt);



        }

        System.out.println(temp1 +" -> "+ max1);
        System.out.println(temp2 +" -> "+ max2);
    }
    
}
