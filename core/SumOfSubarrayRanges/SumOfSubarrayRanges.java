package com.dbc;

import java.util.Stack;

public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        int[] minLeft = new int[nums.length];
        int[] maxLeft = new int[nums.length];
        int[] minRight = new int[nums.length];
        int[] maxRight = new int[nums.length];
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack1.isEmpty() && nums[stack1.peek()] > nums[i]) {
                stack1.pop();
            }
            minLeft[i] = stack1.isEmpty() ? -1 : stack1.peek();
            stack1.push(i);

            while (!stack2.isEmpty() && nums[stack2.peek()] < nums[i]) {
                stack2.pop();
            }
            maxLeft[i] = stack2.isEmpty() ? -1 : stack2.peek();
            stack2.push(i);
        }

        stack1 = new Stack<>();
        stack2 = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack1.isEmpty() && nums[stack1.peek()] >= nums[i]) {
                stack1.pop();
            }
            minRight[i] = stack1.isEmpty() ? nums.length : stack1.peek();
            stack1.push(i);

            while (!stack2.isEmpty() && nums[stack2.peek()] <= nums[i]) {
                stack2.pop();
            }
            maxRight[i] = stack2.isEmpty() ? nums.length : stack2.peek();
            stack2.push(i);
        }

        long minSum = 0, maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            minSum += (long) (i - minLeft[i]) * (minRight[i] - i) * nums[i];
            maxSum += (long) (i - maxLeft[i]) * (maxRight[i] - i) * nums[i];
        }

        return maxSum - minSum;
    }
}
