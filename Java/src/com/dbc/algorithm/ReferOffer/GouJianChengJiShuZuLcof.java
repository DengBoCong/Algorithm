package com.dbc.algorithm.ReferOffer;

import java.util.Arrays;

public class GouJianChengJiShuZuLcof {
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        int temp = 1;
        Arrays.fill(b, 1);
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}
