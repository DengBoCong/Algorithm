package com.dbc.algorithm.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    class KthLargest {
        private PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        private int k;

        public KthLargest(int k, int[] nums) {
            for (int num : nums) {
                this.queue.offer(num);
            }
            while (this.queue.size() > k) {
                this.queue.poll();
            }
            this.k = k;
        }

        public int add(int val) {
            this.queue.add(val);
            while (this.queue.size() > k) {
                this.queue.poll();
            }
            return queue.peek();
        }
    }
}
