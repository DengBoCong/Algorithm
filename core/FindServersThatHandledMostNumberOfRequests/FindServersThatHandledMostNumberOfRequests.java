package com.dbc;

import java.util.*;

public class FindServersThatHandledMostNumberOfRequests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] requests = new int[k];
        Queue<Integer> available = new PriorityQueue<Integer>((a, b) -> a - b);
        for (int i = 0; i < k; i++) available.offer(i);
        Queue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int id = busy.peek()[1];
                busy.poll();
                available.offer(i + ((id - i) % k + k) % k);
            }
            if (available.isEmpty()) continue;
            int server = available.poll() % k;
            requests[server]++;
            busy.offer(new int[]{arrival[i] + load[i], server});
        }
        int max = Arrays.stream(requests).max().getAsInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}
