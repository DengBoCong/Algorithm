package com.dbc.leecode.Algorithm.Solution221_230;

public class Solution222 {
    public boolean isPowerOfTwoS1(int n) {
        while (n != 0) {
            if (n == 1) return true;
            if (n % 2 != 0) return false;
            n = n / 2;
        }
        return false;
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}
