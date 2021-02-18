package com.dbc.algorithm.Math;

public class BulbSwitcherII {
    public static int flipLights(int n, int m) {
        int flag = Math.min(n, 3);
        if (m == 0) return 1;
        if (m == 1) return new int[]{2, 3, 4}[flag - 1];
        if (m == 2) return new int[]{2, 4, 7}[flag - 1];
        return new int[]{2, 4, 8}[flag - 1];
    }
}
