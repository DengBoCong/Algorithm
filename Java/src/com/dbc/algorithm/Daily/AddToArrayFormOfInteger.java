package com.dbc.algorithm.Daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        int length = A.length;
        List<Integer> result = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            K = A[i] + K;
            result.add(K % 10);
            K /= 10;
        }
        while (K > 0) {
            result.add(K % 10);
            K /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}
