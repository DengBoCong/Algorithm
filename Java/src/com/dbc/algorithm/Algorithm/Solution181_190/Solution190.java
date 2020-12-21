package com.dbc.leecode.Algorithm.Solution181_190;

public class Solution190 {
    public int rangeBitwiseAndS1(int m, int n){
        if (m == Integer.MAX_VALUE) return m;

        int res = m;
        for (int i = m + 1; i <= n; i++){
            res &= i;
            if (res == 0 || i == Integer.MAX_VALUE) break;
        }
        return res;
    }

    public int rangeBitwiseAndS2(int m, int n){
        int count = 0;
        while (n > m){
            count++;
            m >>>= 1;
            n >>>= 1;
        }
        return m << count;
    }

    public int rangeBitwiseAnd(int m, int n){
        int zeros = 0;
        while (n > m){
            n = n & (n - 1);
        }
        return n;
    }
}
