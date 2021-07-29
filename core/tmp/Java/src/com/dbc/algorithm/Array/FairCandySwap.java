package com.dbc.algorithm.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int total = (sumA + sumB) / 2;
        Set<Integer> set = new HashSet<>();
        for (int b : B) {
            set.add(b);
        }

        int[] result = new int[2];
        for (int a : A) {
            if (set.contains(total - sumA + a)) {
                result[0] = a;
                result[1] = total - sumA + a;
                break;
            }
        }

        return result;
    }
}
