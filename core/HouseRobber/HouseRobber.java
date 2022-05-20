package com.dbc;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prePreHouse = i - 2 < 0 ? 0 : dp[i - 2];
            int preHouse = i - 1 < 0 ? 0 : dp[i - 1];
            dp[i] = Math.max(nums[i] + prePreHouse, preHouse);
        }
        return dp[nums.length - 1];
    }
}
