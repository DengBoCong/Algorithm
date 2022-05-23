package com.dbc;

import java.util.Stack;

public class YongLiangGeZhanShiXianDuiLieLcof {
    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    public YongLiangGeZhanShiXianDuiLieLcof() {

    }

    public void appendTail(int value) {
        while (!this.stack2.isEmpty()) {
            this.stack1.add(this.stack2.pop());
        }
        this.stack1.add(value);
    }

    public int deleteHead() {
        while (!this.stack1.isEmpty()) {
            this.stack2.add(this.stack1.pop());
        }
        return this.stack2.isEmpty() ? -1 : this.stack2.pop();
    }
}
