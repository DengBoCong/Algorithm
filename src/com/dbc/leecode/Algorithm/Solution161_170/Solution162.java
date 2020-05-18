package com.dbc.leecode.Algorithm.Solution161_170;

public class Solution162 {
    public String convertToTitle(int n){
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0){
            int c = n % 26;
            if (c == 0){
                c = 26;
                n -= 1;
            }
            stringBuilder.insert(0, (char)('A' + c - 1));
            n /= 26;
        }
        return stringBuilder.toString();
    }
}
