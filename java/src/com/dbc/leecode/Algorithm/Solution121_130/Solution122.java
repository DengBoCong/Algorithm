package com.dbc.leecode.Algorithm.Solution121_130;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-21 18:14
 **/
public class Solution122 {
    public int maxProfit(int prices[]){
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minprice){
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
