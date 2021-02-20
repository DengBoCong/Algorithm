package com.dbc.algorithm.Array;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE, max = 1, min = 1;
        for (int num : nums) {
            int mx = max, mi = min;
            max = Math.max(num, Math.max(num * mx, num * mi));
            min = Math.min(num, Math.min(num * mx, num * mi));
            result = Math.max(result, max);
        }
        return result;
    }
}
