package com.dbc.algorithm.Math;

public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        int[] factor = new int[]{2, 3, 5};
        for (int num : factor) {
            while (n % num == 0) {
                n /= num;
            }
        }
        return n == 1;
    }
}
