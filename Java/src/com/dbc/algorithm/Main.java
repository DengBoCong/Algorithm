package com.dbc.algorithm;
import com.dbc.algorithm.Daily.BestTimeToBuyAndSellStockWithCoolDown;
import com.dbc.algorithm.Daily.BestTimeToBuyAndSellStockWithTransactionFee;

public class Main {
    public static void main(String args[]) {
        int profit = BestTimeToBuyAndSellStockWithTransactionFee.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        System.out.println(profit);
    }
}