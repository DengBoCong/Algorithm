package com.dbc;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, left = 0, total = 1;
        for (int i = 0; i < nums.length; i++) {
            total *= nums[i];
            while (left <= i && total >= k) {
                total /= nums[left];
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
}
