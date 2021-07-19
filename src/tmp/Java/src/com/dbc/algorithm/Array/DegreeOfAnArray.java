package com.dbc.algorithm.Array;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public static int findShortestSubArray(int[] nums) {
        int record = 0, result = 50001;
        Map<Integer, int[]> remain = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (remain.containsKey(nums[i])) {
                remain.get(nums[i])[0]++;
                remain.get(nums[i])[2] = i;
            } else {
                remain.put(nums[i], new int[]{1, i, i});
            }
            record = Math.max(record, remain.get(nums[i])[0]);
        }
        for (Map.Entry<Integer, int[]> entry : remain.entrySet()) {
            if (record == entry.getValue()[0]) {
                result = Math.min(result, entry.getValue()[2] - entry.getValue()[1] + 1);
            }
        }
        return result;
    }
}
