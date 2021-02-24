package com.dbc.algorithm.Array;

public class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int left = 0, right = A[0].length - 1;
            while (left <= right) {
                if (left == right) {
                    A[i][left] ^= 1;
                } else if (A[i][left] == A[i][right]) {
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
        }
        return A;
    }
}
