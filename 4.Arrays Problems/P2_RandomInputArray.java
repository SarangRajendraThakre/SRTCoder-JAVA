import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class P2_RandomInputArray {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of Array");
        int size = sc.nextInt();
        int [] arr = new int[size];
        Random random = new Random();

        for(int i = 0 ;i<arr.length ; i++)
        {
            
            // arr[i] = (int) (Math.random()*10);

            arr[i] = (int)(random.nextInt(99));

        }
       System.out.println(Arrays.toString(arr));


    }
}