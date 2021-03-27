package com.dbc.algorithm.ReferOffer;

public class JianShengZiIILcof {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if (b == 0) return (int)(rem * 3 % p);
        if (b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }
}
