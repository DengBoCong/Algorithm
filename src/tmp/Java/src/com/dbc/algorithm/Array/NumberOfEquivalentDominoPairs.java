package com.dbc.algorithm.Array;

public class NumberOfEquivalentDominoPairs {
    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] remain = new int[100];
        int result = 0;
        for (int[] dominoe : dominoes) {
            int val = dominoe[0] >= dominoe[1] ? dominoe[0] * 10 + dominoe[1] : dominoe[1] * 10 + dominoe[0];
            result += remain[val];
            remain[val]++;
        }
        return result;
    }
}
