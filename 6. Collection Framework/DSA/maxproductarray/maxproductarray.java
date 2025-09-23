

public class maxproductarray {
    
     static int maxproduct(int arr[],int n)
 {



    int minval=arr[0];
    int maxval=arr[0];

    int maxproduct =arr[0];
    for(int i=0;i<n;i++){
        if(arr[i]<0)
        {
            int temp=maxval;
            maxval=minval;
            minval=temp;



        }
    }
 }
}
