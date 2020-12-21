package com.dbc.leecode.Algorithm.Solution21_30;

public class Solution28 {
    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
