import java.util.Scanner;

public class P133_P_ {

    public static void main(String[] args) {
        // Your code here

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for pattern to generate : ");
        int row = sc.nextInt();

        // 1

        // 3 2

        // 6 5 4

        // 10 9 8 7

        int counter = 1;
        for (int i = 1; i <= 5; i++) {
            int temp = counter;
            for (int j = 1, k = counter; j <= i; j++, k--) {
                System.out.print(k + " ");

            }

            System.out.println();
            counter = i + 1 + temp;

        }

    }

}
