package com.dbc.algorithm.ReferOffer;

public class LianXuZiShuZuDeZuiDaHeLcof {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] + nums[i - 1];
            if (temp > nums[i]) {
                nums[i] = temp;
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
