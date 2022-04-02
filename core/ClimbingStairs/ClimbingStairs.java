package com.dbc;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 4) return n;
        int pre = 2, cur = 3;
        for (int i = 3; i < n; i++) {
            int temp = cur;
            cur += pre;
            pre = temp;
        }
        return cur;
    }
}
