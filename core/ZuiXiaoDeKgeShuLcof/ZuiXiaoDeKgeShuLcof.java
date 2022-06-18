package com.dbc.code;

import java.util.PriorityQueue;

public class ZuiXiaoDeKgeShuLcof {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) return res;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.add(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
