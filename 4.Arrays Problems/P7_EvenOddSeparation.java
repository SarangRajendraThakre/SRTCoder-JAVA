import java.util.Arrays;

public class P7_EvenOddSeparation {
    
    public static void main(String[] args) {


        int [] mixedarr = {4,35,6,3,2,67,87,334,56};
         System.out.println(Arrays.toString(mixedarr));

        for(int i =  0;i<mixedarr.length;i++)
        {
            if(mixedarr[i]%2 == 0)
            {
                for(int j = i+1 ; j < mixedarr.length ;j++)
                {
                    if( mixedarr[j]%2!=0)
                    {
                        int temp = mixedarr[i];
                        mixedarr[i] = mixedarr[j];
                        mixedarr[j] = temp;
                    }

                }
            }
        }

       System.out.println("-------After separation -----------");

        System.out.println(Arrays.toString(mixedarr));
      

    }
    
}
