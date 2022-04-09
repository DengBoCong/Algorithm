package com.dbc;

public class Sqrtx {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int left = 0, right = x / 2;
        while (Math.pow(left, 2) <= x && x <= Math.pow(right, 2)) {
            int mid = (left + right) / 2;
            if (Math.pow(mid, 2) == x) return mid;
            if (Math.pow(mid, 2) > x) right = mid - 1;
            else left = mid + 1;
        }
        if (Math.pow(left, 2) > x) return left - 1;
        else return right;
    }
}
