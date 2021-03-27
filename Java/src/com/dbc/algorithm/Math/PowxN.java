package com.dbc.algorithm.Math;

public class PowxN {
    public double myPow(double x, int n) {
        long b = n;
        if (b < 0) {
            x = 1. / x;
            b = -b;
        }
        double res = 1.;
        while (b != 0) {
            if (b % 2 == 1) res = res * x;
            x = x * x;
            b = b >> 1;
        }
        return res;
    }
}
