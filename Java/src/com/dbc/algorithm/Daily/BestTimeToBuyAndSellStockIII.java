package com.dbc.algorithm.Daily;

public class BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices) {
        int length = prices.length;

        if (length == 0)
            return 0;

        int sell1 = 0, sell2 = 0;
        int buy1 = -prices[0], buy2 = -prices[0];
        for (int i = 1; i < length; i++) {
            int temp = sell1;
            sell1 = Math.max(sell1, buy1 + prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
            buy1 = Math.max(buy1, -prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
        }

        int sell = Math.max(sell1, sell2);

        return Math.max(0, sell);
    }
}
