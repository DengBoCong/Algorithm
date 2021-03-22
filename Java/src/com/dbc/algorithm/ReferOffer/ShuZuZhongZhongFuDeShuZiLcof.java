package com.dbc.algorithm.ReferOffer;

import java.util.HashMap;
import java.util.Map;

public class ShuZuZhongZhongFuDeShuZiLcof {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, false)) {
                return num;
            }
            map.put(num, true);
        }
        return 0;
    }
}
