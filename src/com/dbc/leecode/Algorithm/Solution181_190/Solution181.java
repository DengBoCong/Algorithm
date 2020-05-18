package com.dbc.leecode.Algorithm.Solution181_190;

public class Solution181 {
    public int reverseBits(int n){
        int res = 0;
        int count = 0;
        while (count < 32){
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
            count++;
        }
        return res;
    }
}
