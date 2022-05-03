package com.dbc;

public class FindFirstAndLastPositionOfElementInSortedArray {
    private void binarySearch(int left, int right, int[] nums, int target, int[] res) {
        if (left > right) return;
        int mid = (left + right) / 2;
        if (nums[mid] > target) binarySearch(left, mid - 1, nums, target, res);
        else if (nums[mid] < target) binarySearch(mid + 1, right, nums, target, res);
        else {
            res[0] = res[0] == -1 ? mid : Math.min(res[0], mid);
            res[1] = res[1] == -1 ? mid : Math.max(res[1], mid);
            binarySearch(left, mid - 1, nums, target, res);
            binarySearch(mid + 1, right, nums, target, res);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        binarySearch(0, nums.length - 1, nums, target, res);
        return res;
    }
}
