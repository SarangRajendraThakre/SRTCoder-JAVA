package duplicate;

public class duplicate {
    
    public static void main(String[] args) {


        int arr[]={5,5,47,43,7,743,75,54,545};
        for(int i=0;i<arr.length;i++)
{
    arr[arr[i]%arr.length]=arr[arr[i]%arr.length]+arr.length;
    
}        
        
    }
}
