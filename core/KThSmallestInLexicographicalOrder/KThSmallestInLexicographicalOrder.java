package com.dbc;

public class KThSmallestInLexicographicalOrder {
    private int getSteps(long cur, int n) {
        int steps = 0;
        long first = cur, last = cur;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }
        return steps;
    }

    public int findKthNumber(int n, int k) {
        long cur = 1;
        k--;
        while (k != 0) {
            int steps = getSteps(cur, n);
            if (steps <= k) {
                k -= steps;
                cur++;
            } else {
                k -= 1;
                cur *= 10;
            }
        }
        return (int) cur;
    }
}
