package com.dbc.algorithm.Pointer;

public class MinimumNumberOfKConsecutiveBitFlips {
    public static int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int result = 0, revCnt = 0;
        for (int i = 0; i < n; i++) {
            revCnt += diff[i];
            if ((revCnt + A[i]) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                diff[i + K]--;
                revCnt++;
                result++;
            }
        }
        return result;
    }
}
