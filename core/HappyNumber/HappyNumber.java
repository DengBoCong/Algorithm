package com.dbc;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> remain = new HashSet<>();
        remain.add(n);
        while (n != 1) {
            int temp = 0;
            while (n != 0) {
                temp += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = temp;
            if (remain.contains(n)) return false;
            remain.add(n);
        }
        return true;
    }
}
