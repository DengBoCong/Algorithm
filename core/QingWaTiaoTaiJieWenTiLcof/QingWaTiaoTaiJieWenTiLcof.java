package com.dbc;

public class QingWaTiaoTaiJieWenTiLcof {
    public int numWays(int n) {
        long pre = 1, cur = 1;
        for (int i = 2; i < n + 1; i++) {
            long temp = cur;
            cur = (cur + pre) % 1000000007;
            pre = temp;
        }
        return (int) cur;
    }
}
