package com.dbc;

import java.util.*;

public class MinStack {
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> stack1 = new Stack<>();

    public MinStack() {
        this.stack1.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        this.stack.push(val);
        this.stack1.push(Math.min(this.stack1.peek(), val));
    }

    public void pop() {
        this.stack.pop();
        this.stack1.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.stack1.peek();
    }
}
