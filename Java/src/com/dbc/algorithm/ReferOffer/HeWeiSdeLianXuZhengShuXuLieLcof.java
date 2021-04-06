package com.dbc.algorithm.ReferOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public int[][] findContinuousSequence(int target) {
        Queue<Integer> queue = new LinkedList<>();
        List<int[]> res = new ArrayList<>();
        int total = 0;
        for (int i = 1; i <= target; i++) {
            while (total > target) {
                total -= queue.poll();
            }
            if (total == target) {
                int[] temp = new int[i - queue.peek()];
                for (int j = queue.peek(); j < i; j++)
                    temp[j - queue.peek()] = j;
                res.add(temp);
            }
            queue.offer(i);
            total += i;
        }
        return res.toArray(new int[res.size()][]);
    }
}
