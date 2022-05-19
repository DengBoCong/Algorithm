package com.dbc;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) res += Math.abs(num - minNum);
        return res;
    }
}
