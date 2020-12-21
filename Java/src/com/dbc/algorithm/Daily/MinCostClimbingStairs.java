package com.dbc.algorithm.Daily;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        for (int i = 2; i < length; i++) {
            cost[i] += cost[i - 1] >= cost[i - 2] ? cost[i - 2] : cost[i - 1];
        }
        return cost[length - 1] < cost[length - 2] ? cost[length - 1] : cost[length - 2];
    }
}
