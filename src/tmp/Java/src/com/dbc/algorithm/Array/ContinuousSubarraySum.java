package com.dbc.algorithm.Array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static boolean checkSubarraySumEnum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                sum += nums[j];
                if (k == 0 && sum == 0) {
                    return true;
                } else if (k != 0 && sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkSubarraySumPrefix(int[] nums, int k) {
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (k != 0) {
                pre %= k;
            }
            if (i - map.getOrDefault(pre, i) > 1) {
                return true;
            }

            if (!map.containsKey(pre)) {
                map.put(pre, i);
            }
        }

        return false;
    }
}
