import java.util.Scanner;

public class P64_P_1_to_n_PerfectNO {

    public static void main(String[] args) {
        // Your code here

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        for(int i = 0;i<n;i++)
        {
             if(perfectNo(i))
        {
            System.out.println(i+" ");
        }
      
        }
       

    }

    public static boolean perfectNo(int num) {
        for (int i = 1; i < num / 2; i++) {

            if (i * i == num) {
                return true;
            }

        }
        return false;
    }
}
