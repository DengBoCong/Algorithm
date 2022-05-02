package com.dbc;

import java.util.Arrays;

public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        Arrays.fill(dp, 0);
        int res = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            int remain = 0;
            for (int j = 1; j < nums2.length + 1; j++) {
                int temp = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) dp[j] = remain + 1;
                else dp[j] = 0;
                remain = temp;
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }
}
