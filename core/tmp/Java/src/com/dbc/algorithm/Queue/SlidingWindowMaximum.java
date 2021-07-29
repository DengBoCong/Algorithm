package com.dbc.algorithm.Queue;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindowPriority(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }

        return ans;
    }

    public static int[] maxSlidingWindowMonotonous(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = nums[deque.getFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            while (deque.getFirst() <= i - k) {
                deque.removeFirst();
            }
            result[i - k + 1] = nums[deque.getFirst()];
        }

        return result;
    }
}
