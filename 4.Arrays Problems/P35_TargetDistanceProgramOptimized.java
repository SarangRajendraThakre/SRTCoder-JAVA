import java.util.Arrays;

public class P35_TargetDistanceProgramOptimized {

    public static void main(String[] args) {

        int n = 3;
        int q = 4;

        int[] distance = { 50, 55, 60 };
        int[] targetDistance = { 60, 50, 50, 65 };

        int[] op = solve(n, q, distance, targetDistance);
        System.out.println(Arrays.toString(op));
    }

    private static int[] solve(int n, int q, int[] distance, int[] targetDistance) {

        Arrays.sort(distance);

        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + distance[i];
        }

        int[] op = new int[q];

        for (int k = 0; k < q; k++) {
            int currentTarget = targetDistance[k];

            int index = Arrays.binarySearch(distance, currentTarget);

            if (index < 0) {
                index = -(index + 1);
            }

            int count_le = index;

            long sumLeft = (long) count_le * currentTarget - prefixSum[count_le];

            long sumRight = (prefixSum[n] - prefixSum[count_le]) - (long) (n - count_le) * currentTarget;

            op[k] = (int) (sumLeft + sumRight);
        }

        return op;
    }
}
