package com.dbc;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buy = -prices[0], sell = 0;
        int res = sell;
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
            res = Math.max(res, sell);
        }
        return res;
    }
}
