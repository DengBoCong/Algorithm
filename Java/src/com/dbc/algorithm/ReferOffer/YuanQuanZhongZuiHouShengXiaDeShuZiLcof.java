package com.dbc.algorithm.ReferOffer;

public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i < n + 1; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
