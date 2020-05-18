package com.dbc.leecode.Algorithm.Solution191_200;

import java.util.Arrays;

public class Solution193 {
    public int countPrimes(int n){
        boolean isPrimes[] = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i * i < n; i++){
            if (isPrimes[i]){
                for (int j = i * i; j < n; j += i)
                    isPrimes[j] = false;
            }
        }

        int res = 0;
        for (int i = 2; i < n; i++){
            if (isPrimes[i]) res++;
        }
        return res;
    }
}
