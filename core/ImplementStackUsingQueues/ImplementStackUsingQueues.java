package com.dbc.code;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    private final Queue<Integer> queue1 = new LinkedList<>();
    private final Queue<Integer> queue2 = new LinkedList<>();

    public ImplementStackUsingQueues() {
    }

    public void push(int x) {
        if (this.queue1.isEmpty()) {
            this.queue1.offer(x);
            while (!this.queue2.isEmpty()) {
                this.queue1.offer(this.queue2.poll());
            }
        } else {
            this.queue2.offer(x);
            while (!this.queue1.isEmpty()) {
                this.queue2.offer(this.queue1.poll());
            }
        }
    }

    public int pop() {
        if (!this.queue1.isEmpty()) return this.queue1.poll();
        else return this.queue2.poll();
    }

    public int top() {
        if (!this.queue1.isEmpty()) return this.queue1.peek();
        else return this.queue2.peek();
    }

    public boolean empty() {
        return this.queue1.isEmpty() && this.queue2.isEmpty();
    }
}
