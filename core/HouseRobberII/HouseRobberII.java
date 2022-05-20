package com.dbc;

public class HouseRobberII {
    private int get_max(int start, int end, int[] nums) {
        int prePreHouse = 0, preHouse = 0;
        for (int i = start; i < end; i++) {
            int cur = Math.max(prePreHouse + nums[i], preHouse);
            prePreHouse = preHouse;
            preHouse = cur;
        }
        return preHouse;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(get_max(0, nums.length - 1, nums), get_max(1, nums.length, nums));
    }
}
