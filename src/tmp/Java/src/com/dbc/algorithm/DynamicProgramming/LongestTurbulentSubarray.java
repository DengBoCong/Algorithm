package com.dbc.algorithm.DynamicProgramming;

public class LongestTurbulentSubarray {
    public static int maxTurbulenceSize(int[] arr) {
        int ne = 1, op = 1, result = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                op = ne + 1;
                ne = 1;
            } else if (arr[i] > arr[i - 1]) {
                ne = op + 1;
                op = 1;
            } else {
                ne = 1;
                op = 1;
            }

            result = Math.max(result, Math.max(ne, op));
        }

        return result;
    }
}
