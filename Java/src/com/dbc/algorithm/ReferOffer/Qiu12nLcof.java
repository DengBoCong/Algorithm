package com.dbc.algorithm.ReferOffer;

public class Qiu12nLcof {
    private int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
