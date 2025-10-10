
public class lscs {
    public static void main(String[] args) {
        int[] a = { 4, 5, 64, 5, 65, 84, 884 };
        System.out.println("maximum continous subarray is " + maxcontisa(a));

    }

    static int maxcontisa(int[] a) {
        int size = a.length;
        int max_ending_here = 0, max_so_far = Integer.MIN_VALUE;

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
