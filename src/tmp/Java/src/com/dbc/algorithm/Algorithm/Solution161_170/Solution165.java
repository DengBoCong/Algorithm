package com.dbc.leecode.Algorithm.Solution161_170;

public class Solution165 {
    public int trailingZeroes(int n){
        int count = 0;
        while (n > 0){
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
