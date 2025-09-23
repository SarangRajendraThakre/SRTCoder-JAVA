import java.util.Arrays;

public class P4_ZigZagMergingOfArrays {

    public static void main(String[] args) {

        

        int[] arr1 ={1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10 , 34 ,37};

        System.out.println("First Array : "+ Arrays.toString(arr1) + "  Second Arrays : "+ Arrays.toString(arr2));

        int result[] = new int[arr1.length + arr2.length];

 int i=0 , j=0 , k = 0;
        while( arr1.length > i && arr2.length > j )
        {
            result[k++]  =  arr1[i++];
            result[k++]  =  arr2[j++];
        }
        while(arr1.length > i)
        {
            result[k++] = arr1[i++];
        }
        while(arr2.length > j)
        {
            result[k++] = arr2[j++];
        }


        System.out.println(Arrays.toString(result));
        


    }
}