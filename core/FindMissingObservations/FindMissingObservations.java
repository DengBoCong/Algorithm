package com.dbc;

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum_m = 0;
        for (int num : rolls) sum_m += num;
        int sum_n = (rolls.length + n) * mean - sum_m;
        if (sum_n > n * 6 || sum_n < n) return new int[0];
        int count = 0;
        while (sum_n >= n) {
            count++;
            sum_n -= n;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i < sum_n ? count + 1 : count;
        }
        return res;
    }
}
