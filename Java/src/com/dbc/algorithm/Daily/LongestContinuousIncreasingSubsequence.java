package com.dbc.algorithm.Daily;

public class LongestContinuousIncreasingSubsequence {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int result = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 1;
            }
        }

        return Math.max(result, count);
    }
}
