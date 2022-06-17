package com.dbc.code;

import java.util.ArrayDeque;
import java.util.Queue;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) queue.offer(0);
            queue.offer(arr[i]);
            arr[i] = queue.poll();
        }
    }
}
