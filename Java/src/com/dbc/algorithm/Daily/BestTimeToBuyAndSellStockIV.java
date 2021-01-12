package com.dbc.algorithm.Daily;

public class BestTimeToBuyAndSellStockIV {
    public static int maxProfitDp(int k, int[] prices) {
        int length = prices.length;
        if (length == 0 || k == 0)
            return 0;

        int[] buy = new int[k];
        int[] sell = new int[k];

        for (int i = 0; i < k; i++) {
            buy[i] = -prices[0];
            sell[i] = 0;
        }

        for (int i = 1; i < length; i++) {
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }

        return Math.max(0, sell[k - 1]);
    }

    public static int maxProfitWqsBinary(int k, int[] prices) {
        int length = prices.length;
        if (length == 0 || k == 0)
            return 0;

        int right = 0;
        int left = 1;
        for (int i = 0; i < length; i++)
            right = Math.max(right, prices[i]);

        int ans = -1;
        while (left <= right) {
            int c = (left + right) / 2;
            int buyCount = 0, sellCount = 0;
            int buy = -prices[0], sell = 0;

            for (int i = 1; i < length; i++) {
                if (sell - prices[i] >= buy) {
                    buy = sell - prices[i];
                    buyCount = sellCount;
                }
                if (buy + prices[i] - c >= sell) {
                    sell = buy + prices[i] - c;
                    sellCount = buyCount + 1;
                }
            }

            if (sellCount >= k) {
                ans = sell + k * c;
                left = c + 1;
            } else {
                right = c - 1;
            }
        }

        if (ans == -1) {
            ans = 0;
            for (int i = 1; i < length; i++) {
                ans += Math.max(prices[i] - prices[i - 1], 0);
            }
        }

        return ans;
    }
}
