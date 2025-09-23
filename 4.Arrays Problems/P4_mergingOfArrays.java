import java.util.Arrays;

public class P4_mergingOfArrays {

    public static void main(String[] args) {
        
        int [] a= {1,2,3,4,5,6};
        int [] b= {1,2,3,4,5,6};
        int []c = new int[a.length + b.length];

        for(int i = 0 , j = 0 ;i<c.length ;i++)
        {
            if(i < a.length)
            {
              c[i]=a[i];

            }
            else
            {
              c[i] = b[j++];
            }
        }

        System.out.println(Arrays.toString(c));

        

    }
    
}
