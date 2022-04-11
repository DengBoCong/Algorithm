package com.dbc;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 1;
        for (int i = 1; i < n + 1; i++) {
            int start = 9, mid = 9;
            int remain = i;
            while (remain > 1) {
                mid *= start;
                remain--;
                start--;
            }
            res += mid;
        }
        return res;
    }
}
