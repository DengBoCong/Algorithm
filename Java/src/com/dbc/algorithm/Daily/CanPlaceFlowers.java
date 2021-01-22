package com.dbc.algorithm.Daily;

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, length = flowerbed.length, prev = -1;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                if (count >= n)
                    return true;
                prev = i;
            }
        }
        if (prev < 0) {
            count += (length - prev) / 2;
        } else {
            count += (length - prev - 1) / 2;
        }
        return count >= n;
    }
}
