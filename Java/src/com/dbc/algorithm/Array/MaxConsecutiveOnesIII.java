package com.dbc.algorithm.Array;

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] A, int K) {
        int left = 0, right = 0, max = 0;
        while (right < A.length) {
            if (A[right] == 1) {
                max++;
            }
            if (right - left + 1 - max > K) {
                if (A[left] == 1) {
                    max--;
                }
                left++;
            }
            right++;
        }
        return right - left;
    }
}
