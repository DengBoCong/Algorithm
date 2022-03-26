package com.dbc;

import java.util.Random;

public class SortAnArray {
    public void quickSort(int left, int right, int[] nums) {
        int point = (left + right) / 2;
        swap(left, point, nums);
        int mid = nums[left], l = left, r = right;
        while (l < r) {
            while (l < r && nums[r] >= mid) r--;
            if (l < r) {
                nums[l] = nums[r];
                l++;
            }
            while (l < r && nums[l] <= mid) l++;
            if (l < r) {
                nums[r] = nums[l];
                r--;
            }
        }
        nums[l] = mid;
        if (l - 1 > left) quickSort(left, l - 1, nums);
        if (l + 1 < right) quickSort(l + 1, right, nums);
    }

    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int[] sortArray(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        return nums;
    }
}
