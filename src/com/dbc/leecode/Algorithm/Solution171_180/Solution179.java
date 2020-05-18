package com.dbc.leecode.Algorithm.Solution171_180;

import java.util.*;

public class Solution179 {
    class Transaction {
        int valley;
        int peek;

        Transaction(int v, int p){
            valley = v;
            peek = p;
        }
    }

    public int maxProfit(int k, int[] prices){
        if (k == 0){
            return 0;
        }
        Stack<Transaction> stack = new Stack<>();
        List<Integer> profit = new ArrayList<>();
        int v;
        int p = -1;
        int n = prices.length;
        while (true){
            v = p + 1;
            while (v + 1 < n && prices[v] > prices[v + 1]){
                v++;
            }
            p = v;
            while (p + 1 < n && prices[p] <= prices[p + 1]){
                p++;
            }
            if (p == v){
                break;
            }
            while (!stack.isEmpty() && prices[v] <= prices[stack.peek().valley]){
                Transaction pop = stack.pop();
                profit.add(prices[pop.peek] - prices[pop.valley]);
            }

            while (!stack.isEmpty() && prices[p] >= prices[stack.peek().peek]){
                Transaction pop = stack.pop();
                profit.add(prices[pop.peek] - prices[v]);
                v = pop.valley;
            }
            stack.push(new Transaction(v, p));
        }
        while (!stack.isEmpty()){
            Transaction pop = stack.pop();
            profit.add(prices[pop.peek] - prices[pop.valley]);
        }
        int ret = 0;
        if (k >= profit.size()){
            for (int i = 0; i < profit.size(); i++){
                ret += profit.get(i);
            }
        }else {
            Collections.sort(profit, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int i = 0; i < k; i++){
                ret += profit.get(i);
            }
        }
        return ret;
    }
}
