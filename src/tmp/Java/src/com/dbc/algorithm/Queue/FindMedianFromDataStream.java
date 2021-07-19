package com.dbc.algorithm.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    class MedianFinder {
        private int k = 0;
        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;
        private int smallSize = 0, largeSize = 0;

        public MedianFinder() {
            small = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            large = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }

        private void makeBalance() {
            if (smallSize > largeSize + 1) {
                large.offer(small.peek());
                small.poll();
                largeSize++;
                smallSize--;
            } else if (smallSize < largeSize) {
                small.offer(large.peek());
                large.poll();
                largeSize--;
                smallSize++;
            }
        }

        public void addNum(int num) {
            k++;
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num);
                smallSize++;
            }else {
                large.offer(num);
                largeSize++;
            }
            makeBalance();
        }

        public double findMedian() {
            return (k & 1) == 1 ? small.peek() : ((double)small.peek() + large.peek()) / 2;
        }
    }
}
