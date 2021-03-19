package com.dbc.algorithm.BitOperation;

public class CountingBits {
    public int[] countBits(int num) {
        int[] remain = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            int temp = i & (i - 1);
            remain[i] = 1 + remain[temp];
        }
        return remain;
    }
}
