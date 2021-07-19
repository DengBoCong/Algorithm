package com.dbc.algorithm.Queue;

import java.util.*;

public class SlidingWindowMedian {
    class DualHeap {
        private int k;
        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;
        private Map<Integer, Integer> count;
        private int smallSize = 0, largeSize = 0;

        public DualHeap(int k) {
            small = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            large = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            count = new HashMap<Integer, Integer>();
            this.k = k;
        }

        private void prune(PriorityQueue<Integer> queue) {
            while (!queue.isEmpty()) {
                int num = queue.peek();
                if (count.getOrDefault(num, 0) > 0) {
                    count.put(num, count.get(num) - 1);
                    queue.poll();
                } else break;
            }
        }

        private void makeBalance() {
            if (smallSize > largeSize + 1) {
                large.offer(small.poll());
                prune(small);
                smallSize--;
                largeSize++;
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                prune(large);
                smallSize++;
                largeSize--;
            }
        }

        public void insert(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num);
                smallSize++;
            } else {
                large.offer(num);
                largeSize++;
            }
            makeBalance();
        }

        public void erase(int num) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (num <= small.peek()) {
                smallSize--;
                if (num == small.peek()) {
                    prune(small);
                }
            } else {
                largeSize--;
                if (num == large.peek()) {
                    prune(large);
                }
            }
            makeBalance();
        }

        public double getMedian() {
            return k % 2 == 1 ? small.peek() : ((double)small.peek() + large.peek()) / 2;
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dualHeap = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dualHeap.insert(nums[i]);
        }
        double[] result = new double[nums.length - k + 1];
        result[0] = dualHeap.getMedian();
        for (int i = k; i < nums.length; i++) {
            dualHeap.insert(nums[i]);
            dualHeap.erase(nums[i - k]);
            result[i - k + 1] = dualHeap.getMedian();
        }
        return result;
    }
}
