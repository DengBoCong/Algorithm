package com.dbc.algorithm.Array;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    public static int subarraysWithKDistinct(int[] A, int K) {
        int total1 = 0, total2 = 0, left1 = 0, left2 = 0, result = 0;
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (count1.getOrDefault(A[i], 0) == 0) {
                total1++;
            }
            count1.put(A[i], count1.getOrDefault(A[i], 0) + 1);
            if (count2.getOrDefault(A[i], 0) == 0) {
                total2++;
            }
            count2.put(A[i], count2.getOrDefault(A[i], 0) + 1);

            while (total1 > K) {
                count1.put(A[left1], count1.get(A[left1]) - 1);
                if (count1.get(A[left1]) == 0) {
                    total1--;
                }
                left1++;
            }
            while (total2 > K - 1) {
                count2.put(A[left2], count2.get(A[left2]) - 1);
                if (count2.get(A[left2]) == 0) {
                    total2--;
                }
                left2++;
            }
            result += left2 - left1;
        }
        return result;
    }
}
