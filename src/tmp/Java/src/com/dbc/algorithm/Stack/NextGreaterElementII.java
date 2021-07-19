package com.dbc.algorithm.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.isEmpty() && nums[stack.lastElement()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return result;
    }
}
