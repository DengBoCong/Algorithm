package com.dbc;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> remain = new HashMap<Integer, Integer>(){{
            put(0, 0);
        }};
        for (int i = 1; i <= amount; i++) {
            int mid = -1;
            for (int coin : coins) {
                if (i - coin >= 0 && remain.containsKey(i - coin)) {
                    mid = mid == -1 ? remain.get(i - coin) : Math.min(mid, remain.get(i - coin));
                }
            }
            if (mid != -1) remain.put(i, mid + 1);
        }
        return remain.getOrDefault(amount, -1);
    }
}
