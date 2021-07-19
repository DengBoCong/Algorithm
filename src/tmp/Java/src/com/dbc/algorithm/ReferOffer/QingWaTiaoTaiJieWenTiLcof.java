package com.dbc.algorithm.ReferOffer;

public class QingWaTiaoTaiJieWenTiLcof {
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        int f1 = 1, f2 = 2;
        for (int i = 0; i < n - 2; i++) {
            int temp = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = temp;
        }
        return f2;
    }
}
