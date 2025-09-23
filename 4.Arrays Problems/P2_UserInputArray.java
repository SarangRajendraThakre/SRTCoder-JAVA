import java.util.Arrays;
import java.util.Scanner;

public class P2_UserInputArray {

    public static void main(String[] args) {
  
        
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array ");
        int size = sc.nextInt();
        int [] arr = new int[size];
        for(int i =0 ;i<size;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
     }
    
}
