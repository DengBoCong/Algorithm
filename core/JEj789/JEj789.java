package com.dbc.code;

public class JEj789 {
    public int minCost(int[][] costs) {
        int first = 0, second = 0, third = 0;
        for (int[] cost : costs) {
            int item1 = cost[0] + Math.min(second, third);
            int item2 = cost[1] + Math.min(first, third);
            int item3 = cost[2] + Math.min(first, second);
            first = item1;
            second = item2;
            third = item3;
        }
        return Math.min(first, Math.min(second, third));
    }
}
