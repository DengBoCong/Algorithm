package com.dbc.algorithm.ReferOffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShuJuLiuZhongDeZhongWeiShuLcof {
    private Queue<Integer> max;
    private Queue<Integer> min;
    public ShuJuLiuZhongDeZhongWeiShuLcof() {
        max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        min = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public void addNum(int num) {
        if (max.size() == min.size()) {
            min.offer(num);
            max.offer(min.poll());
        } else {
            max.offer(num);
            min.offer(max.poll());
        }
    }

    public double findMedian() {
        if (max.size() == min.size()) {
            return (double)(max.peek() + min.peek()) / 2.;
        } else {
            return max.peek();
        }
    }
}
