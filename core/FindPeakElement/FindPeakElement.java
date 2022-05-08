package com.dbc;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) return mid;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }
}
