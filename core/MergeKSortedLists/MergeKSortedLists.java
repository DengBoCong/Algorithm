package com.dbc;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, ListNode> map = new HashMap<>();
        int count = 0;
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new int[]{node.val, count});
                map.put(count, node);
                count++;
            }
        }

        ListNode res = new ListNode();
        ListNode preHead = res;
        while (!queue.isEmpty()) {
            int[] nodeCount = queue.poll();
            ListNode node = map.get(nodeCount[1]);
            preHead.next = node;
            preHead = preHead.next;
            if (node.next != null) {
                queue.offer(new int[]{node.next.val, count});
                map.put(count, node.next);
                count++;
            }
        }
        return res.next;
    }
}
