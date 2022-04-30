package com.dbc;


public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return Math.max(0, max - min - 2 * k);
    }
}
