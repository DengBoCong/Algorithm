package com.dbc.algorithm;
import com.dbc.algorithm.Daily.BestTimeToBuyAndSellStockWithCoolDown;

public class Main {
    public static void main(String args[]) {
        int profit = BestTimeToBuyAndSellStockWithCoolDown.maxProfit_memo_recursion(new int[]{1,2,3,0,2});
        System.out.println(profit);
    }
}