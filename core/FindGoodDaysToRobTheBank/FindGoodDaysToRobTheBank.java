package com.dbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindGoodDaysToRobTheBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] left = new int[security.length];
        int[] right = new int[security.length];
        Arrays.fill(left, 0);
        Arrays.fill(right, 0);

        for (int i = 1; i < security.length - 1; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[security.length - 1 - i] <= security[security.length - i]) {
                right[security.length - 1 - i] = right[security.length - i] + 1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < security.length; i++) {
            if (left[i] >= time && right[i] >= time) {
                res.add(i);
            }
        }

        return res;
    }
}
