import java.util.Scanner;

public class P63_P_PerfectNO {

    public static void main(String[] args) {
        // Your code here

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        if(perfectNo(n))
        {
            System.out.println("The number is perfect no");
        }
        else
        {
            System.out.println("The number is not a perfect no");
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
