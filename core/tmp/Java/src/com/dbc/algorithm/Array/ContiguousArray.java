package com.dbc.algorithm.Array;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int sum0 = 0, sum1 = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) sum0++;
            else sum1++;

            int num = sum0 - sum1;
            if (num == 0) {
                result = Math.max(result, i + 1);
            } else if (map.getOrDefault(num, 50000) != 50000) {
                result = Math.max(result, i - map.get(num));
            } else {
                map.put(num, i);
            }
        }

        return result;
    }
}
