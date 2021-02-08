package com.dbc.algorithm.DynamicProgramming;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i] + nums[i - 1]) {
                nums[i] = nums[i] + nums[i - 1];
            }
            result = Math.max(result, nums[i]);
        }

        return result;
    }
}
