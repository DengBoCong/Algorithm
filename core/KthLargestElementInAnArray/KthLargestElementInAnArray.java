package com.dbc;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(0, nums.length - 1, k, nums);
    }

    public int quickSort(int left, int right, int k, int[] nums) {
        int l = left, r = right;
        int mid = nums[left];
        while (l < r) {
            while (l < r && nums[r] <= mid) {
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
                l++;
            }
            while (l < r && nums[l] >= mid) {
                l++;
            }
            if (l < r) {
                nums[r] = nums[l];
                r--;
            }
        }

        nums[l] = mid;
        if (l + 1 == k) return mid;
        else if (l + 1 > k) {
            return quickSort(left, l - 1, k, nums);
        } else {
            return quickSort(l + 1, right, k, nums);
        }
    }
}
