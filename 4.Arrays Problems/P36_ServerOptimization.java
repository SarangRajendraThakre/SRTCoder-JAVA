import java.util.Arrays;

public class P36_ServerOptimization {

    public static int optimizeServers(int[] power, int[] cost) {
        if (power == null || cost == null || power.length != cost.length) {
            throw new IllegalArgumentException("Power and cost arrays must be non-null and have the same length.");
        }

        int n = power.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int efficientServersCount = 0;

        for (int i = 0; i < n; i++) {
            boolean isInefficient = false;

            for (int j = 0; j < n; j++) {

                if (i == j) {
                    continue;
                }

                if (power[j] > power[i] && cost[j] < cost[i]) {
                    isInefficient = true;
                    break;
                }
            }

            if (!isInefficient) {
                efficientServersCount++;
            }
        }

        return efficientServersCount;
    }

    public static void main(String[] args) {

        int[] power1 = { 1, 2, 3 };
        int[] cost1 = { 1, 4, 2 };
        System.out.println("Example 1:");
        System.out.println("Power: " + Arrays.toString(power1));
        System.out.println("Cost: " + Arrays.toString(cost1));
        System.out.println("Efficient servers: " + optimizeServers(power1, cost1));

        System.out.println("\n---");

        int[] power2 = { 10, 20, 30 };
        int[] cost2 = { 3, 2, 1 };
        System.out.println("Example 2:");
        System.out.println("Power: " + Arrays.toString(power2));
        System.out.println("Cost: " + Arrays.toString(cost2));
        System.out.println("Efficient servers: " + optimizeServers(power2, cost2));

        System.out.println("\n---");

        int[] power3 = { 5, 1, 8, 3 };
        int[] cost3 = { 20, 5, 10, 15 };
        System.out.println("Example 3:");
        System.out.println("Power: " + Arrays.toString(power3));
        System.out.println("Cost: " + Arrays.toString(cost3));

        System.out.println("Efficient servers: " + optimizeServers(power3, cost3));

        System.out.println("\n---");

        int[] power4 = { 100 };
        int[] cost4 = { 50 };
        System.out.println("Example 4:");
        System.out.println("Power: " + Arrays.toString(power4));
        System.out.println("Cost: " + Arrays.toString(cost4));
        System.out.println("Efficient servers: " + optimizeServers(power4, cost4));
    }
}