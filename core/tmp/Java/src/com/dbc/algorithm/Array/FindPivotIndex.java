package com.dbc.algorithm.Array;

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int present = 0;
        for (int i = 0; i < nums.length; i++) {
            if (present == total - present - nums[i]) {
                return i;
            }
            present += nums[i];
        }

        return -1;
    }
}
