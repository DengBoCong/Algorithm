package com.dbc.leecode.Algorithm.Solution231_240;

public class Solution239 {
    public int missingNumberS1(int[] nums) {
        int sum = 0;
        int max = 0;
        boolean flag = false;
        if (nums.length == 1 && nums[0] == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] > max) max = nums[i];
            if (nums[i] == 0) flag = true;
        }

        int temp = max + max * (max - 1) / 2 - sum;
        if (temp != 0) return temp;
        else if (flag) return max++;
        else return 0;
    }

    public int missingNumberS2(int[] nums) {
        int temp = nums.length * (nums.length + 1) / 2;
        int sum = 0;
        for (int num : nums) sum += num;
        return temp - sum;
    }

    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) sum ^= i ^ nums[i];
        return sum;
    }
}
