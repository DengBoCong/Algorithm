package com.dbc.leecode.Algorithm.Solution221_230;

import java.util.Stack;

public class Solution223 {
    class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        private int front;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public void pop() {
            stack1.pop();
            if (!stack1.isEmpty())
                front = stack1.peek();
        }

        /** Get the front element. */
        public int peek() {
            return front;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty();
        }
    }
}
