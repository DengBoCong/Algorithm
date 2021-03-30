package com.dbc.algorithm.Stack;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        if (pushed.length == 0) return true;

        int point1 = 0, point2 = 0;
        Stack<Integer> stack = new Stack<>();
        while (point1 < pushed.length && point2 < popped.length) {
            stack.push(pushed[point1]);
            point1++;
            if (stack.peek() == popped[point2]) {
                while (!stack.isEmpty() && stack.peek() == popped[point2]) {
                    stack.pop();
                    point2++;
                }
            }
        }
        return stack.size() == 0;
    }
}
