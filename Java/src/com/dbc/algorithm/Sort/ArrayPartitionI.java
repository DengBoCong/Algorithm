package com.dbc.algorithm.Sort;

import java.util.Arrays;

public class ArrayPartitionI {
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r = right, mid = nums[left];
        while (l < r) {
            while (l < r && nums[r] >= mid) {
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
                l++;
            }
            while (l < r && nums[l] <= mid) {
                l++;
            }
            if (l < r) {
                nums[r] = nums[l];
                r--;
            }
        }
        nums[l] = mid;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
