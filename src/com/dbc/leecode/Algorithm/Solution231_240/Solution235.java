package com.dbc.leecode.Algorithm.Solution231_240;

public class Solution235 {
    public int addDigitsS1(int num) {
        while (num >= 10) {
            int tmp = 0;
            while (num != 0) {
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
        }
        return num;
    }

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
