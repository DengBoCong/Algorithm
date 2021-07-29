package com.dbc.algorithm.ReferOffer;

public class GuPiaoDeZuiDaLiRunLcof {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}
