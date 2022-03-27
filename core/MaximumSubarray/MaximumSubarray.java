package com.dbc;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = nums[0], prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(nums[i], prev + nums[i]);
            res = Math.max(res, prev);
        }
        return res;
    }
}
