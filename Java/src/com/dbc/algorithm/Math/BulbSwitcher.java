package com.dbc.algorithm.Math;

public class BulbSwitcher {
    public static int bulbSwitch(int n) {
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i * i <= n)
                result++;
            else break;
        }
        return result;
    }
}
