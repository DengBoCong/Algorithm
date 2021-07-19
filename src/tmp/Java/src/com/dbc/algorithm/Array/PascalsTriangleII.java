package com.dbc.algorithm.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        int remain = 0;
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (j == 1) {
                    remain = result.get(j);
                    result.set(j, result.get(j) + result.get(j - 1));
                } else {
                    int temp = result.get(j);
                    result.set(j, result.get(j) + remain);
                    remain = temp;
                }
            }
            result.add(1);
        }
        return result;
    }
}
