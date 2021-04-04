package com.dbc.algorithm.Array;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += Math.ceil((double)entry.getValue() / ((double)entry.getKey() + 1.)) * (entry.getKey() + 1);
        }
        return res;
    }
}
