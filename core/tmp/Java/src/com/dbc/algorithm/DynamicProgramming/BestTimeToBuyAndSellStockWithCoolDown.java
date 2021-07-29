package com.dbc.algorithm.DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCoolDown {
    public static int maxProfitDp(int[] prices) {
        int length = prices.length;
        if (length == 0)
            return 0;

        int buy = -prices[0], sell = 0, freeze = 0;
        for (int i = 1; i < length; i++) {
            int temp1 = buy, temp2 = sell;
            buy = Math.max(buy, freeze - prices[i]);
            sell = Math.max(sell, temp1 + prices[i]);
            freeze = Math.max(freeze, temp2);
        }

        return Math.max(sell, freeze);
    }

    public static int maxProfit_memo_recursion(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[][] memo = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++)
            Arrays.fill(memo[i], -1);

        return trade(prices, 0, 1, memo);
    }

    public static int trade(int[] prices, int day, int state, int[][] memo) {
        if (day >= prices.length)
            return 0;
        if (memo[day][state] != -1)
            return memo[day][state];

        int buy = 0, sell = 0;
        if (state == 0) {
            buy = prices[day] + trade(prices, day + 2, 1, memo);
        } else {
            sell = -prices[day] + trade(prices, day + 1, 0, memo);
        }

        int freeze = trade(prices, day + 1, state, memo);
        memo[day][state] = Math.max(buy, Math.max(sell, freeze));
        return memo[day][state];
    }
}
