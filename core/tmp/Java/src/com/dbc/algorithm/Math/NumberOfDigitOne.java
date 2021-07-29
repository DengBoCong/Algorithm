package com.dbc.algorithm.Math;

public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int res = 0, low = 0, k = 1;
        while (n != 0) {
            int high = n / 10;
            int cur = n % 10;
            if (cur == 0) res += high * k;
            else if (cur == 1) res += high * k + low + 1;
            else res += (high + 1) * k;
            low += cur * k;
            n /= 10;
            k *= 10;
        }
        return res;
    }
}
