package com.dbc.algorithm.Array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.getOrDefault(temp, 10000) != 10000) {
                return new int[]{i, map.get(temp)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
