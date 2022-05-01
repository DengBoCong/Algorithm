package com.dbc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumCostForTickets {
    private final Map<Integer, Integer> set = new HashMap<>();
    private final int[] memo = new int[366];

    public int mincostTickets(int[] days, int[] costs) {
        for (int day : days) set.put(day, 0);
        int[] license = new int[]{1, 7, 30};
        Arrays.fill(this.memo, -1);
        return dp(1, costs, license);
    }

    private int dp(int i, int[] costs, int[] license) {
        if (i > 365) return 0;
        if (this.memo[i] != -1) return this.memo[i];
        if (this.set.containsKey(i)) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp(i + license[j], costs, license) + costs[j]);
            }
            this.memo[i] = min;
        } else {
            return this.memo[i] = dp(i + 1, costs, license);
        }
        return this.memo[i];
    }
}
