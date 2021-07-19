package com.dbc.algorithm.ReferOffer;

import java.util.Stack;

public class YongLiangGeZhanShiXianDuiLieLcof {
    private Stack<Integer> stackFront;
    private Stack<Integer> stackBack;
    public YongLiangGeZhanShiXianDuiLieLcof() {
        stackFront = new Stack<>();
        stackBack = new Stack<>();
    }

    public void appendTail(int value) {
        while (!stackBack.isEmpty()) {
            stackFront.push(stackBack.pop());
        }
        stackFront.push(value);
    }

    public int deleteHead() {
        while (!stackFront.isEmpty()) {
            stackBack.push(stackFront.pop());
        }
        if (!stackBack.isEmpty()) {
            return stackBack.pop();
        } else {
            return -1;
        }
    }
}
