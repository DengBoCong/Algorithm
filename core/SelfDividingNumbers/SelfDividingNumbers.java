package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public boolean isDiv(int num) {
        if (num == 0) return false;
        int remain = num;
        while (num != 0) {
            if (num % 10 == 0 || remain % (num % 10) != 0) return false;
            num /= 10;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isDiv(i)) res.add(i);
        }
        return res;
    }
}
