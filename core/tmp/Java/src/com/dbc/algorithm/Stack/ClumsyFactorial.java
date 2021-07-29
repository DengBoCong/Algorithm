package com.dbc.algorithm.Stack;

import java.util.Stack;

public class ClumsyFactorial {
    public int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();
        stack.push(N);
        int flag = 0;
        for (int i = N - 1; i > 0; i--) {
            if (flag % 4 == 0) {
                stack.push(stack.pop() * i);
            } else if (flag % 4 == 1) {
                stack.push(stack.pop() / i);
            } else if (flag % 4 == 2) {
                stack.push(i);
            } else if (flag % 4 == 3) {
                stack.push(-i);
            }
            flag++;
        }

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }
}
