package com.dbc.algorithm.Daily;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        if (length == 0)
            return 0;

        int buy = -prices[0], sell = 0;
        for (int i = 1; i < length; i++) {
            int temp = buy;
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, temp + prices[i] - fee);
        }

        return Math.max(0, sell);
    }
}
