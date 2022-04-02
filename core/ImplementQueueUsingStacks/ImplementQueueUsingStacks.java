package com.dbc;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    public ImplementQueueUsingStacks() {
    }

    public void push(int x) {
        while (!this.stack2.isEmpty()) this.stack1.push(this.stack2.pop());
        this.stack1.push(x);
    }

    public int pop() {
        while (!this.stack1.isEmpty()) this.stack2.push(this.stack1.pop());
        return this.stack2.pop();
    }

    public int peek() {
        while (!this.stack1.isEmpty()) this.stack2.push(this.stack1.pop());
        return this.stack2.peek();
    }

    public boolean empty() {
        return this.stack1.isEmpty() && this.stack2.isEmpty();
    }
}
