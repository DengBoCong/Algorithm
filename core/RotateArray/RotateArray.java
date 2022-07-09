package com.dbc.code;

import java.util.Arrays;
import java.util.Collection;

public class RotateArray {
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, (k - 1) % nums.length);
        reverse(nums, (k - 1) % nums.length + 1, nums.length - 1);
    }
}
