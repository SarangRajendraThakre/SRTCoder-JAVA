package Recursion;

import java.util.*;

 class factorNumber {   // becauses of this class is not public i can't run it  , but compile it.

    public static void main(String[] args) {
        System.out.println("enter a number");
        int num = new Scanner(System.in).nextInt();

        find_Factors(num, 1);

    }

    public static void find_Factors(int num, int i) {
        if (num % i == 0)
        {
          System.out.println(i + " ");
        }
        if (i > num) {
            return;
        }

        find_Factors(num, ++i);

    }
}