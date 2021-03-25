package com.dbc.algorithm.ReferOffer;

public class FeiBoNaQiShuLieLcof {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int f1 = 0, f2 = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = temp;
        }
        return f2;
    }
}
