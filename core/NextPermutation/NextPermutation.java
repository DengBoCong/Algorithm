package com.dbc;

public class NextPermutation {
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2, right = nums.length - 1;
        while (left >= 0 && nums[left] >= nums[left + 1]) left--;
        if (left >= 0) {
            while (nums[left] >= nums[right]) right--;
            swap(nums, left, right);
        }
        left++;
        right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
