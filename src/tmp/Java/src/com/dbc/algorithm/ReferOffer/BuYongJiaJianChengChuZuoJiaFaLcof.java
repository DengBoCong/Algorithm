package com.dbc.algorithm.ReferOffer;

public class BuYongJiaJianChengChuZuoJiaFaLcof {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
