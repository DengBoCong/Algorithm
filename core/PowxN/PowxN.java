package com.dbc;

public class PowxN {
    private double cal(double x, int n) {
        if (n == 0) return 1;
        return n % 2 == 0 ? cal(x * x, n / 2) : cal(x * x, n / 2) * x;
    }

    public double myPow(double x, int n) {
        double res = cal(x, Math.abs(n));
        return n >= 0 ? res : 1 / res;
    }
}
