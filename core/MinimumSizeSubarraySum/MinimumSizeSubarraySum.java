package com.dbc;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, res = 0, total = 0;
        while (right < nums.length) {
            total += nums[right];
            while (total >= target) {
                res = res == 0 ? right - left + 1 : Math.min(res, right - left + 1);
                total -= nums[left];
                left++;
            }
            right++;
        }
        return res;
    }
}
