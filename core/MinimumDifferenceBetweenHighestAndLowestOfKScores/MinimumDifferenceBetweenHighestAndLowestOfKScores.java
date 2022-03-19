package com.dbc;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int point = k - 1, res = 100000;
        while (point < nums.length) {
            res = Math.min(res, nums[point] - nums[point - k + 1]);
            point++;
        }
        return res;
    }
}
