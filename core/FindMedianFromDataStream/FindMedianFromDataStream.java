package com.dbc.code;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    private final PriorityQueue<Integer> queue1 = new PriorityQueue<>((a, b) -> a - b);
    private final PriorityQueue<Integer> queue2 = new PriorityQueue<>((a, b) -> b - a);

    public FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        if (this.queue2.isEmpty() || num <= this.queue2.peek()) {
            this.queue2.offer(num);
            if (this.queue1.size() + 1 < this.queue2.size()) {
                this.queue1.offer(this.queue2.poll());
            }
        } else {
            this.queue1.offer(num);
            if (this.queue1.size() > this.queue2.size()) {
                this.queue2.offer(this.queue1.poll());
            }
        }
    }

    public double findMedian() {
        if (this.queue1.size() == this.queue2.size()) return (this.queue1.peek() + this.queue2.peek()) / 2.;
        else return this.queue2.peek();
    }
}
