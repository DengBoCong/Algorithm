package com.dbc.algorithm.DynamicProgramming;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 0)
            return 0;

        int bottom = prices[0];
        int profit = 0;
        for (int i = 0; i < len; i++) {
            profit = Math.max(profit, prices[i] - bottom);
            bottom = Math.min(bottom, prices[i]);
        }

        return profit;
    }
}
