package com.dbc.leecode.Algorithm.Solution201_210;

import java.util.HashMap;
import java.util.Map;

public class Solution210 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return false;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (map.containsKey(tmp)) {
                min = Math.min(min, i - map.get(tmp));
            }
            map.put(tmp, i);
        }
        if (min <= k) return true;
        else return false;
    }
}
