package com.dbc;

public class BinarySearch {
    private int binarySearch(int left, int right, int target, int[] nums) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        int leftNum = binarySearch(left, mid - 1, target, nums);
        int rightNum = binarySearch(mid + 1, right, target, nums);
        if (leftNum != -1) return leftNum;
        if (rightNum != -1) return rightNum;
        return -1;
    }

    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, target, nums);
    }
}
