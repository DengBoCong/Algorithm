package com.dbc.algorithm.ReferOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DuiLieDeZuiDaZhiLcof {
    Queue<Integer> q;
    Deque<Integer> d;

    public DuiLieDeZuiDaZhiLcof() {
        q = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}
