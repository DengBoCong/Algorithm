package com.dbc.leecode.Algorithm.Solution21_30;

public class Solution30 {
    public static int divide(int dividend, int divisor) {
        int dividend1 = Math.abs(dividend);
        int divisor1 = Math.abs(divisor);
        int sum = 0;
        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += divisor1;
            if(sum > dividend1 && dividend < 0 && divisor > 0) return -i;
            if(sum > dividend1 && dividend > 0 && divisor < 0) return -i;
            if(sum > dividend1) return i;
        }
        return Integer.MAX_VALUE - 1;
    }
}
