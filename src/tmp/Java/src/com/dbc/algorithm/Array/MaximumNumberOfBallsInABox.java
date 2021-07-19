package com.dbc.algorithm.Array;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBallsInABox {
    public static int countBalls(int lowLimit, int highLimit) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int num = i, remain = 0;
            while (num > 0) {
                remain += num % 10;
                num /= 10;
            }
            map.put(remain, map.getOrDefault(remain, 0) + 1);
            result = Math.max(map.get(remain), result);
        }

        return result;
    }
}
