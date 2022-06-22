package com.dbc.code;

public class LianXuZiShuZuDeZuiDaHeLcof {
    public int maxSubArray(int[] nums) {
        int min = nums[0], res = nums[0], total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            total += nums[i];
            res = Math.max(res, total - min);
            min = Math.min(min, total);
        }
        return res;
    }
}
