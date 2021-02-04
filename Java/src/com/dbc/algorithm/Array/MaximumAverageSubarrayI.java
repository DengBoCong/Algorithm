package com.dbc.algorithm.Array;

public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < k; i++) {
            result += nums[i];
        }
        int remain = result;
        for (int i = k; i < nums.length; i++) {
            remain = remain + nums[i] - nums[i - k];
            result = Math.max(result, remain);
        }

        return (double) result / k;
    }
}
