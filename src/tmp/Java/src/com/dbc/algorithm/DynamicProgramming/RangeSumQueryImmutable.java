package com.dbc.algorithm.DynamicProgramming;

public class RangeSumQueryImmutable {
    private int[] remain;
    public RangeSumQueryImmutable(int[] nums) {
        remain = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            remain[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return remain[j];
        else {
            return remain[j] - remain[i - 1];
        }
    }
}
