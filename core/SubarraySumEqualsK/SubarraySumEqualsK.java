package com.dbc;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Long, Integer> map = new HashMap<Long, Integer>(){{
            put(0L, 1);
        }};
        long total = 0;
        int res = 0;
        for (int num : nums) {
            total += num;
            res += map.getOrDefault(total - k, 0);
            map.put(total, map.getOrDefault(total, 0) + 1);
        }
        return res;
    }
}
