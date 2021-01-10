package com.dbc.algorithm.Daily;

public class BestTimeToBuyAndSellStockII {
    public static int maxProfitDp(int[] prices) {
        int length = prices.length;
        if (length == 0)
            return 0;

        int profit1 = 0;
        int profit2 = -prices[0];
        for (int i = 1; i < length; i++) {
            int temp = profit1;
            profit1 = Math.max(profit1, profit2 + prices[i]);
            profit2 = Math.max(profit2, profit1 - prices[i]);
        }

        return profit1;
    }

    public static int maxProfitGreed(int[] prices) {
        int length = prices.length;
        if (length == 0)
            return 0;

        int profit = 0;
        for (int i = 1; i < length; i++) {
            profit += Math.max(prices[i] - prices[i - 1], 0);
        }
        return profit;
    }
}
