import java.io.*;
import java.util.*;

public class largestsumcontisubarray {
    public static void main(String[] args) {
        int[] a = { 7, -1, 5, 7, 7, -6, -8, -5, 5 };
        System.out.println("maximum contiguous sum is " + maxsubArraySum(a));

    }

    static int maxsubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;

            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }

}
