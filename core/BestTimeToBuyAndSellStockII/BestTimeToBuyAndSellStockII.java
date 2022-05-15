package com.dbc;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int sell = 0, buy = -prices[0];
        for (int price : prices) {
            int temp = sell;
            sell = Math.max(sell, buy + price);
            buy = Math.max(buy, temp - price);
        }
        return sell;
    }
}
