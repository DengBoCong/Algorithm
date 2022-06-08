package com.dbc;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                res[stack.peek()[0]] = i - stack.peek()[0];
                stack.pop();
            }
            stack.add(new int[]{i, temperatures[i]});
        }

        return res;
    }
}
