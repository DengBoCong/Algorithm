package com.dbc.leecode.Algorithm.Solution231_240;

public class Solution236 {
    public int[] singleNumberS1(int[] nums) {
        int[] res = new int[2];
        int count = 0;
        quickSort(nums, 0, nums.length - 1);
        for (int i = 1; i < nums.length; i++) {
            if (count == 2) break;
            if (nums[i] != nums[i - 1]) {
                res[count] = nums[i - 1];
                count++;
                continue;
            }
            i++;
        }
        if (count == 1) res[count] = nums[nums.length - 1];
        return res;
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

    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null) return res;

        int tmp = 0;
        for (int num : nums) tmp ^= num;

        int diff = tmp & (-tmp);

        int x = 0;
        for (int num : nums) if ((num & diff) != 0) x ^= num;
        res[0] = x;
        res[1] = tmp ^ x;
        return  res;
    }
}
