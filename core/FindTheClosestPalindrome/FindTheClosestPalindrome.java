package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        int length = n.length();
        long int_n = Long.parseLong(n);
        long prefix = Long.parseLong(n.substring(0, (length + 1) / 2));
        List<Long> candidate = new ArrayList<>();
        candidate.add((long) (Math.pow(10, (length - 1)) - 1));
        candidate.add((long) (Math.pow(10, length) + 1));
        for (long i = prefix - 1; i < prefix + 2; i++) {
            long y = length % 2 == 0 ? i : i / 10;
            long x = i;
            while (y != 0) {
                x = x * 10 + y % 10;
                y /= 10;
            }
            candidate.add(x);
        }

        long res = -1;
        for (long candi : candidate) {
            if (candi - int_n != 0) {
                if (res == -1 || Math.abs(int_n - candi) < Math.abs(int_n - res)) {
                    res = candi;
                }
            }
        }
        return Long.toString(res);
    }
}
