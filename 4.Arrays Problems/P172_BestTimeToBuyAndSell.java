import java.util.Arrays;

public class P172_BestTimeToBuyAndSell {

    public static void main(String[] args) {
        // Your code here

        System.out.println(bestTimeToBuyAndSellOnePassGreedy(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(bestTimeToBuyAndSellBruteForce(new int[] { 7, 1, 5, 3, 6, 4 }));

    }

    public static int bestTimeToBuyAndSellOnePassGreedy(int[] arr) {

        int min = arr[0];
        int profit = 0;

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            profit = Math.max(profit, arr[i] - min);
        }
        return profit;

    }

    public static int bestTimeToBuyAndSellBruteForce(int[] arr) {

        int maxProfit = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int profit = arr[j] - arr[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

}

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

// https://chatgpt.com/c/68e7a8e0-dccc-8324-9354-2298984f85ba