package com.dbc.algorithm.ReferOffer;

public class QueShiDeShuZiLcof {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1, res = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] != mid) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
