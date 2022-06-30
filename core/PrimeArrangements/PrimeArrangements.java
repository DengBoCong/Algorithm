package com.dbc.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeArrangements {
    private int countPrime(int num) {
        boolean[] isPrime = new boolean[num];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (isPrime[i - 1]) primes.add(i);
            for (int prime : primes) {
                if (i * prime > num) break;
                isPrime[i * prime - 1] = false;
                if (i % prime == 0) break;
            }
        }
        return primes.size();
    }

    public int numPrimeArrangements(int n) {
        int count = countPrime(n);
        long res = 1;
        for (int i = 1; i <= count; i++) {
            res *= i;
        }
        for (int i = 1; i <= n - count; i++) {
            res *= i;
        }
        return (int) (res % 1000000007L);
    }
}
