package com.dbc;

import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) queue.poll();
            res[i - k + 1] = queue.peek()[0];
        }
        return res;
    }
}
