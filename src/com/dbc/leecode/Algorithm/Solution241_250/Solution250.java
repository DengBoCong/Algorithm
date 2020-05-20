package com.dbc.leecode.Algorithm.Solution241_250;

public class Solution250 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        quickSort(citations, 0, len - 1);
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int l = left;
        int r = right;
        int mid = nums[l];

        while (l < r) {
            while (l < r && nums[r] >= mid)
                r--;
            if (l < r) nums[l++] = nums[r];
            while (l < r && nums[l] <= mid)
                l++;
            if (l < r) nums[r--] = nums[l];
        }
        nums[l] = mid;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }
}
