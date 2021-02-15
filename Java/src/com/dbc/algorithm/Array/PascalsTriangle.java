package com.dbc.algorithm.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            if (i == 0) {
                result.add(row);
                continue;
            }
            List<Integer> last = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                row.add(last.get(j) + last.get(j - 1));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}
