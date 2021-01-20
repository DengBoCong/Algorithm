package com.dbc.algorithm.Daily;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        int M = 0;
        List<Boolean> result = new ArrayList<>();
        for (int num : A) {
            M = ((M << 1) + num) % 5;
            result.add(M == 0);
        }

        return result;
    }
}
