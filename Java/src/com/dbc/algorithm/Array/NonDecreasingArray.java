package com.dbc.algorithm.Array;

public class NonDecreasingArray {
    public static boolean checkPossibility(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}
