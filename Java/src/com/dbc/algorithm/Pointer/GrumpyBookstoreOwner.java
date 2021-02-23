package com.dbc.algorithm.Pointer;

public class GrumpyBookstoreOwner {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int left = 0, right = 0, total = 0, remain = 0;
        while (right < X) {
            if (grumpy[right] == 0) {
                total += customers[right];
            } else {
                remain += customers[right];
            }
            right++;
        }
        int max = remain;
        while (right < grumpy.length) {
            if (grumpy[right] == 0) {
                total += customers[right];
            } else {
                remain += customers[right];
            }
            if (grumpy[left] == 1) {
                remain -= customers[left];
            }
            max = Math.max(max, remain);
            left++;
            right++;
        }
        return total + max;
    }
}
