package com.dbc.algorithm.ReferOffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ZuiXiaoDeKgeShuLcof {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[]{};
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
