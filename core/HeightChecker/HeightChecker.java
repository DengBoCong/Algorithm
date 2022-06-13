package com.dbc;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] remain = heights.clone();
        int res = 0;
        Arrays.sort(remain);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != remain[i]) res++;
        }
        return res;
    }
}
