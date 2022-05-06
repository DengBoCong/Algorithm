package com.dbc;

import java.util.Deque;
import java.util.LinkedList;

public class NumberOfRecentCalls {
    Deque<Integer> queue = new LinkedList<>();
    public NumberOfRecentCalls() {

    }

    public int ping(int t) {
        this.queue.addLast(t);
        while (this.queue.peekFirst() < t - 3000) this.queue.pollFirst();
        return this.queue.size();
    }
}
