package com.dbc;

public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int minNum = nums[0], divNum = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minNum && nums[i] - minNum > divNum) {
                divNum = nums[i] - minNum;
            }
            minNum = Math.min(minNum, nums[i]);
        }
        return divNum;
    }
}
