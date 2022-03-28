package com.dbc;

public class SearchInRotatedSortedArray {
    public int bSearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        int leftNum = bSearch(nums, left, mid - 1, target);
        int rightNum = bSearch(nums, mid + 1, right, target);
        if (leftNum != -1) return leftNum;
        else if (rightNum != -1) return rightNum;
        else return -1;
    }

    public int search(int[] nums, int target) {
        return bSearch(nums, 0, nums.length - 1, target);
    }
}
