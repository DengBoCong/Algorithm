package com.dbc;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        long res = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            res = res * x / y;
        }
        return (int) res;
    }
}
