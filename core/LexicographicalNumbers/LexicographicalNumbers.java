package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    private final List<Integer> res = new ArrayList<>();
    private void order(int num, int n) {
        for (int i = 0; i < 10; i++) {
            if (num * 10 + i > n) return;
            res.add(num * 10 + i);
            order(num * 10 + i, n);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            if (i <= n) {
                res.add(i);
                order(i, n);
            }
        }
        return res;
    }
}
