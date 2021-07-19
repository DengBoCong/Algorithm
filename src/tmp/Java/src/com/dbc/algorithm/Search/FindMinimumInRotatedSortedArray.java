package com.dbc.algorithm.Search;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int length = nums.length;
        int left = 0, right = length - 1, res = 50001;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid - 1;
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            }
            res = Math.min(res, nums[mid]);
        }
        return res;
    }
}
