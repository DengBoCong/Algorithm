package com.dbc;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, res = 6000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[left]) {
                res = Math.min(res, nums[left]);
                left = mid + 1;
            } else {
                res = Math.min(res, nums[mid]);
                right = mid - 1;
            }
        }
        return res;
    }
}
