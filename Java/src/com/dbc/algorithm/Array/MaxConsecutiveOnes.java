package com.dbc.algorithm.Array;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }

        return Math.max(result, count);
    }
}
