package com.dbc;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp_min = Math.min(Math.min(nums[i], nums[i] * min), nums[i] * max);
            int temp_max = Math.max(Math.max(nums[i], nums[i] * min), nums[i] * max);
            min = temp_min;
            max = temp_max;
            res = Math.max(res, max);
        }
        return res;
    }
}
