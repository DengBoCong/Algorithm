package com.dbc.leecode.Algorithm.Solution211_220;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution216 {
    class MyStack {
        private LinkedList<Integer> queue;
        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            int sz = queue.size();
            while (sz > 1) {
                queue.add(queue.remove());
                sz--;
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int res = queue.getFirst();
            queue.remove();
            return res;
        }

        /** Get the top element. */
        public int top() {
            return queue.getFirst();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
