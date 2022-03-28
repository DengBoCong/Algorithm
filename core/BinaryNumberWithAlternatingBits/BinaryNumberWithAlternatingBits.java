package com.dbc;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int flag = -1;
        while (n != 0) {
            if (flag != -1 && flag == n % 2) return false;
            flag = n % 2;
            n >>= 1;
        }
        return true;
    }
}
